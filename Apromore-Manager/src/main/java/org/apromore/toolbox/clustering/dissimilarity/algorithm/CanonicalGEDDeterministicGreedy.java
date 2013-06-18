package org.apromore.toolbox.clustering.dissimilarity.algorithm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import com.google.common.collect.TreeMultimap;
import com.google.common.collect.TreeMultiset;
import nl.tue.tm.is.led.StringEditDistance;
import org.apromore.graph.canonical.CPFNode;
import org.apromore.graph.canonical.Canonical;
import org.apromore.toolbox.clustering.dissimilarity.model.GEDEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Graph Edit Distance Deterministic Greedy Algorithm Implementation.
 *
 * @author <a href="mailto:cam.james@gmail.com">Cameron James</a>
 */
public class CanonicalGEDDeterministicGreedy extends AbstractCanonicalDistanceAlgorithm implements CanonicalDistanceAlgorithm {

    private static final Logger LOGGER = LoggerFactory.getLogger(CanonicalGEDDeterministicGreedy.class);

    boolean deterministic = true;


    /**
     * @see CanonicalDistanceAlgorithm#compute(org.apromore.graph.canonical.Canonical, org.apromore.graph.canonical.Canonical)
     *      {@inheritDoc}
     */
    @Override
    public double compute(Canonical sg1, Canonical sg2) {
        init(sg1, sg2);

        GEDEdge couple;
        Vector<GEDEdge> bestCandidates;
        Set<GEDEdge> newMapping;
        Set<GEDEdge> newOpenCouples;
        Set<GEDEdge> mapping = new HashSet<>();
        Set<GEDEdge> openCouples = findCouples(sg1.getNodes(), sg2.getNodes());

        String tmp, label1, label2, contextkey, firstkey;
        double newEditDistance;
        double newShortestEditDistance;
        double shortestEditDistance = Double.MAX_VALUE;
        Random randomized = new Random();

        TreeMultiset<String> mset;
        TreeMultimap<String, GEDEdge> tmap;
        TreeMultimap<String, GEDEdge> tmapp;

        boolean doStep = true;
        while (doStep) {
            doStep = false;
            bestCandidates = new Vector<>();
            newShortestEditDistance = shortestEditDistance;

            for (GEDEdge oCouple : openCouples) {
                newMapping = new HashSet<>(mapping);
                newMapping.add(oCouple);
                newEditDistance = this.editDistance(newMapping);
                LOGGER.debug("Couple Distance: " + newEditDistance + " - " + oCouple.getSource().getId() + " * " + oCouple.getTarget().getId());

                if (newEditDistance < newShortestEditDistance) {
                    bestCandidates = new Vector<>();
                    bestCandidates.add(oCouple);
                    newShortestEditDistance = newEditDistance;
                } else if (newEditDistance == newShortestEditDistance) {
                    bestCandidates.add(oCouple);
                }
            }

            if (bestCandidates.size() > 0) {
                // Case 1: Only one candidate pair
                if (bestCandidates.size() == 1)
                    couple = bestCandidates.firstElement();
                else {
                    //  CASE 2: Lexicographical order is enough
                    tmap = TreeMultimap.create();
                    for (GEDEdge pair : bestCandidates) {
                        label1 = pair.getSource().getName();
                        label2 = pair.getTarget().getName();
                        if (label1.compareTo(label2) > 0) {
                            tmp = label1;
                            label1 = label2;
                            label2 = tmp;
                        }
                        tmap.put(label1 + label2, pair);
                    }
                    firstkey = tmap.keySet().first();
                    LOGGER.debug("firstkey: " + firstkey);

                    if (tmap.get(firstkey).size() == 1) {
                        couple = tmap.get(firstkey).first();

                    } else if (tmap.get(firstkey).size() > 1) {
                        tmapp = TreeMultimap.create();
                        mset = TreeMultiset.create();
                        for (GEDEdge pair : tmap.get(firstkey)) {
                            label1 = pair.getSource().getName();
                            mset.clear();
                            for (CPFNode n : sg1.getDirectPredecessors(pair.getSource())) {
                                mset.add(n.getName());
                            }
                            label1 += mset.toString();
                            mset.clear();
                            for (CPFNode n : sg1.getDirectSuccessors(pair.getSource())) {
                                mset.add(n.getName());
                            }
                            label1 += mset.toString();

                            label2 = pair.getTarget().getName();
                            mset.clear();
                            for (CPFNode n : sg2.getDirectPredecessors(pair.getTarget())) {
                                mset.add(n.getName());
                            }
                            label2 += mset.toString();
                            mset.clear();
                            for (CPFNode n : sg2.getDirectSuccessors(pair.getTarget())) {
                                mset.add(n.getName());
                            }
                            label2 += mset.toString();

                            if (label1.compareTo(label2) > 0) {
                                tmp = label1;
                                label1 = label2;
                                label2 = tmp;
                            }
                            tmapp.put(label1 + label2, pair);
                        }
                        contextkey = tmapp.keySet().first();

                        // CASE 3: Composite labels (concatenation of labels of nodes surrounding the target vertex)
                        if (tmapp.get(contextkey).size() == 1) {
                            couple = tmapp.get(contextkey).first();

                        } else {
                            // CASE 4: Non deterministic choice (Choose a random candidate)
                            deterministic = false;
                            couple = bestCandidates.get(randomized.nextInt(bestCandidates.size()));
                        }
                    } else {
                        // CASE 5: Non deterministic choice (Choose a random candidate)
                        deterministic = false;
                        couple = bestCandidates.get(randomized.nextInt(bestCandidates.size()));
                    }
                }

                newOpenCouples = new HashSet<>();
                for (GEDEdge p : openCouples) {
                    if (!p.getSource().getId().equalsIgnoreCase(couple.getSource().getId()) && !p.getTarget().getId().equalsIgnoreCase(couple.getTarget().getId())) {
                        newOpenCouples.add(p);
                    }
                }
                openCouples = newOpenCouples;
                LOGGER.debug("openCouples: " + openCouples.size());

                mapping.add(couple);
                shortestEditDistance = newShortestEditDistance;
                doStep = true;
            }
        }
        LOGGER.debug("Mappings: " + mapping.size());

        return shortestEditDistance;
    }

    /*  */
    private Set<GEDEdge> findCouples(Set<CPFNode> a, Set<CPFNode> b) {
        Set<GEDEdge> result = new HashSet<>();
        for (CPFNode ea : a) {
            for (CPFNode eb : b) {
                if (StringEditDistance.similarity(ea.getName(), eb.getName()) >= this.ledcutoff) {
                    result.add(new GEDEdge(ea, eb));
                }
            }
        }
        return result;
    }


    /* Reset the Deterministic flag. */
    public void resetDeterminismFlag() {
        deterministic = true;
    }

    /* Is the Deterministic flag currently set on? */
    public boolean isDeterministic() {
        return deterministic;
    }
}
