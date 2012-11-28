package org.apromore.dao.model;

import org.springframework.beans.factory.annotation.Configurable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * FragmentVersion generated by hbm2java
 */
@Entity
@Table(name = "fragment_version",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"uri"})
        }
)
@Configurable("fragmentVersion")
public class FragmentVersion implements Serializable {

    private Integer id;
    private String uri;
    private String childMappingCode;
    private Integer lockStatus;
    private Integer lockCount;
    private String derivedFromFragment;
    private Integer fragmentSize;
    private String fragmentType;
    private String newestNeighbor;

    private Content content;
    private Cluster cluster;

    private Set<ProcessModelVersion> processModelVersions = new HashSet<ProcessModelVersion>(0);
    private Set<ProcessModelVersion> rootProcessModelVersions = new HashSet<ProcessModelVersion>(0);

//    private Set<FragmentVersionDag> fragmentVersionDagsForFragmentVersion = new HashSet<FragmentVersionDag>(0);
//    private Set<FragmentVersionDag> fragmentVersionDagsForChildFragmentVersion = new HashSet<FragmentVersionDag>(0);

//    private Set<ClusterAssignment> clusterAssignments = new HashSet<ClusterAssignment>(0);
//    private Set<FragmentDistance> fragmentVersionId1 = new HashSet<FragmentDistance>(0);
//    private Set<FragmentDistance> fragmentVersionId2 = new HashSet<FragmentDistance>(0);


    /**
     * Public Constructor.
     */
    public FragmentVersion() { }



    /**
     * returns the Id of this Object.
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the Id of this Object
     * @param id the new Id.
     */
    public void setId(final Integer id) {
        this.id = id;
    }



    /**
     * The URI of this fragmentVersion.
     * @return the uri
     */
    @Column(name = "uri", length = 40)
    public String getUri() {
        return this.uri;
    }

    /**
     * The URI of this fragmentVersion.
     * @param newUri the new uri.
     */
    public void setUri(final String newUri) {
        this.uri = newUri;
    }


    @Column(name = "child_mapping_code", length = 20000)
    public String getChildMappingCode() {
        return this.childMappingCode;
    }

    public void setChildMappingCode(final String newChildMappingCode) {
        this.childMappingCode = newChildMappingCode;
    }


    @Column(name = "lock_status")
    public Integer getLockStatus() {
        return this.lockStatus;
    }

    public void setLockStatus(final Integer newLockStatus) {
        this.lockStatus = newLockStatus;
    }


    @Column(name = "lock_count")
    public Integer getLockCount() {
        return this.lockCount;
    }

    public void setLockCount(final Integer newLockCount) {
        this.lockCount = newLockCount;
    }


    @Column(name = "derived_from_fragment")
    public String getDerivedFromFragment() {
        return this.derivedFromFragment;
    }

    public void setDerivedFromFragment(final String newDerivedFromFragment) {
        this.derivedFromFragment = newDerivedFromFragment;
    }


    @Column(name = "fragment_size")
    public Integer getFragmentSize() {
        return this.fragmentSize;
    }

    public void setFragmentSize(final Integer newFragmentSize) {
        this.fragmentSize = newFragmentSize;
    }


    @Column(name = "fragment_type", length = 10)
    public String getFragmentType() {
        return this.fragmentType;
    }

    public void setFragmentType(final String newFragmentType) {
        this.fragmentType = newFragmentType;
    }


    @Column(name = "newest_neighbor", length = 40)
    public String getNewestNeighbor() {
        return this.newestNeighbor;
    }

    public void setNewestNeighbor(final String newNewestNeighbor) {
        this.newestNeighbor = newNewestNeighbor;
    }



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "fragmentVersions")
//    @JoinTable(name = "process_fragment_map", joinColumns = {
//            @JoinColumn(name = "fragmentVersionId", nullable = false, updatable = false) }, inverseJoinColumns = {
//            @JoinColumn(name = "processModelVersionId", nullable = false, updatable = false) })
    public Set<ProcessModelVersion> getProcessModelVersions() {
        return this.processModelVersions;
    }

    public void setProcessModelVersions(Set<ProcessModelVersion> processModelVersions) {
        this.processModelVersions = processModelVersions;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contentId")
    public Content getContent() {
        return this.content;
    }

    public void setContent(final Content newContent) {
        this.content = newContent;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clusterId")
    public Cluster getCluster() {
        return this.cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rootFragmentVersion")
    public Set<ProcessModelVersion> getRootProcessModelVersions() {
        return this.rootProcessModelVersions;
    }

    public void setRootProcessModelVersions(Set<ProcessModelVersion> processModelVersions) {
        this.rootProcessModelVersions = processModelVersions;
    }


//    // bi-directional many-to-one association to FragmentVersionDag
//    @OneToMany(mappedBy = "fragmentVersionId")
//    public Set<FragmentVersionDag> getFragmentVersionDags1() {
//        return this.fragmentVersionDagsForFragmentVersion;
//    }
//
//    public void setFragmentVersionDags1(Set<FragmentVersionDag> fragmentVersionDags) {
//        this.fragmentVersionDagsForFragmentVersion = fragmentVersionDags;
//    }
//
//
//    // bi-directional many-to-one association to FragmentVersionDag
//    @OneToMany(mappedBy = "childFragmentVersionId")
//    public Set<FragmentVersionDag> getFragmentVersionDagsForChildFragmentVersion() {
//        return this.fragmentVersionDagsForChildFragmentVersion;
//    }
//
//    public void setFragmentVersionDagsForChildFragmentVersion(Set<FragmentVersionDag> fragmentVersionDags) {
//        this.fragmentVersionDagsForChildFragmentVersion = fragmentVersionDags;
//    }
}

