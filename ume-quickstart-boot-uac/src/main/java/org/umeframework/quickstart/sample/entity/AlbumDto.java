
package org.umeframework.quickstart.sample.entity;

import java.io.Serializable;
import org.umeframework.dora.validation.constraints.Size;
import org.umeframework.dora.type.ColumnDesc;
import org.umeframework.dora.validation.constraints.NotEmpty;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.umeframework.dora.type.TableDesc;
import javax.persistence.Id;
import org.umeframework.dora.bean.BeanUtil;
import org.umeframework.dora.service.TableObject;

/**
 * Entity class map to table "唱片基本信息表"
 *
 * @author ume-team
 */
@Entity
@Table(name="ALBUM")
@TableDesc(label="唱片基本信息表")
public class AlbumDto extends TableObject implements Serializable {
   /**
    * Default serial version code
    */
    private static final long serialVersionUID = 1L;

   /**
    * 编号 
    */
    @NotEmpty
    @Id
    @ColumnDesc(index=1, type="AUTO-INCREMENT", label="编号")
    @Column(name="ID", nullable=false)
    private Long id;

   /**
    * 标题 
    */
    @NotEmpty
    @Size(max=128)
    @ColumnDesc(index=2, type="VARCHAR", label="标题")
    @Column(name="TITLE", nullable=false, length=128)
    private String title;

   /**
    * 艺术家 
    */
    @NotEmpty
    @Size(max=32)
    @ColumnDesc(index=3, type="VARCHAR", label="艺术家")
    @Column(name="ARTIST", nullable=false, length=32)
    private String artist;

   /**
    * 发行时间 
    */
    @ColumnDesc(index=4, type="DATE", label="发行时间")
    @Column(name="ISSUE_DATE", nullable=true)
    private java.sql.Date issueDate;

   /**
    * 风格 
    */
    @Size(min=2, max=2)
    @ColumnDesc(index=5, type="CHAR", label="风格")
    @Column(name="GENRE", nullable=true, length=2)
    private String genre;

   /**
    * 封面设计 
    */
    @ColumnDesc(index=6, type="BLOB", label="封面设计")
    @Column(name="COVER_PHOTO", nullable=true)
    private java.sql.Blob coverPhoto;

   /**
    * Create Author (default setting while insert)
    */
    @ColumnDesc(index=(6 + 1), type="VARCHAR", label="createAuthor")
    @Column(name="CREATE_AUTHOR", nullable=true, length=32)
    private String createAuthor;
   /**
    * Create Datetime (default setting while insert)
    */
    @ColumnDesc(index=(6 + 2), type="TIMESTAMP", label="createDatetime")
    @Column(name="CREATE_DATETIME", nullable=true)
    private java.sql.Timestamp createDatetime;
   /**
    * Update Author (refresh on each update)
    */
    @ColumnDesc(index=(6 + 3), type="VARCHAR", label="updateAuthor")
    @Column(name="UPDATE_AUTHOR", nullable=true, length=32)
    private String updateAuthor;
   /**
    * Update Datetime (refresh on each update)
    */
    @ColumnDesc(index=(6 + 4), type="TIMESTAMP", label="updateDatetime")
    @Column(name="UPDATE_DATETIME", nullable=true)
    private java.sql.Timestamp updateDatetime;
    /**
     *　Get the "编号"
     */
    public Long getId() {
        return this.id;
    }
    /**
     *　Set the "编号"
     */
    public void setId(
            Long id) {
        this.id = id;
    }

    /**
     *　Get the "标题"
     */
    public String getTitle() {
        return this.title;
    }
    /**
     *　Set the "标题"
     */
    public void setTitle(
            String title) {
        this.title = title;
    }

    /**
     *　Get the "艺术家"
     */
    public String getArtist() {
        return this.artist;
    }
    /**
     *　Set the "艺术家"
     */
    public void setArtist(
            String artist) {
        this.artist = artist;
    }

    /**
     *　Get the "发行时间"
     */
    public java.sql.Date getIssueDate() {
        return this.issueDate;
    }
    /**
     *　Set the "发行时间"
     */
    public void setIssueDate(
            java.sql.Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     *　Get the "风格"
     */
    public String getGenre() {
        return this.genre;
    }
    /**
     *　Set the "风格"
     */
    public void setGenre(
            String genre) {
        this.genre = genre;
    }

    /**
     *　Get the "封面设计"
     */
    public java.sql.Blob getCoverPhoto() {
        return this.coverPhoto;
    }
    /**
     *　Set the "封面设计"
     */
    public void setCoverPhoto(
            java.sql.Blob coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    /**
     * Get the "Create Auther"
     */
    public String getCreateAuthor() {
        return createAuthor;
    }
    /**
     * Set the "Create Auther"
     */
    public void setCreateAuthor(
            String createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * Get the "Create Datetime"
     */
    public java.sql.Timestamp getCreateDatetime() {
        return createDatetime;
    }
    /**
     * Set the "Create Datetime"
     */
    public void setCreateDatetime(
            java.sql.Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * Get the "Update Auther"
     */
    public String getUpdateAuthor() {
        return updateAuthor;
    }
    /**
     * Set the "Update Auther"
     */
    public void setUpdateAuthor(
            String updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    /**
     * Get the "Update Datetime"
     */
    public java.sql.Timestamp getUpdateDatetime() {
        return updateDatetime;
    }
    /**
     * Set the "Update Datetime"
     */
    public void setUpdateDatetime(
            java.sql.Timestamp updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
    /**
     * Create bean instance copy with selected properties
     * 
     * @param selectProperties
     *            - properties which copy to new instance
     * @return
     */
    public AlbumDto copyFrom(
            Property... selectProperties) {
        if (selectProperties == null) {
            return null;
        }
        AlbumDto newInstance = new AlbumDto();
        for (Property property : selectProperties) {
            String name = property.toString();
            Object value = BeanUtil.getBeanProperty(this, name);
            BeanUtil.setBeanProperty(newInstance, name, value);
        }
        return newInstance;
    }
    
    /**
     * Constant declare: SQL ID in config file
     */
    public static class SQLID {
        public static final String INSERT = "org.umeframework.quickstart.sample.entity.ALBUM_INSERT";
        public static final String UPDATE = "org.umeframework.quickstart.sample.entity.ALBUM_UPDATE";
        public static final String UPDATE_FULLY = "org.umeframework.quickstart.sample.entity.ALBUM_UPDATE_FULLY";
        public static final String UPDATE_ANY = "org.umeframework.quickstart.sample.entity.ALBUM_UPDATE_ANY";
        public static final String DELETE = "org.umeframework.quickstart.sample.entity.ALBUM_DELETE";
        public static final String FIND = "org.umeframework.quickstart.sample.entity.ALBUM_FIND";
        public static final String FIND_FOR_UPDATE = "org.umeframework.quickstart.sample.entity.ALBUM_FIND_FOR_UPDATE";
        public static final String FIND_LIST = "org.umeframework.quickstart.sample.entity.ALBUM_FIND_LIST";
        public static final String FIND_LIST_LIKE = "org.umeframework.quickstart.sample.entity.ALBUM_FIND_LIST_LIKE";
        public static final String COUNT = "org.umeframework.quickstart.sample.entity.ALBUM_COUNT";
    } 

    /**
     * Constant declare: entity property name.<br>
     */
    public static class Property {
        public static final String id = "id";
        public static final String title = "title";
        public static final String artist = "artist";
        public static final String issueDate = "issueDate";
        public static final String genre = "genre";
        public static final String coverPhoto = "coverPhoto";
        public static final String createAuthor = "createAuthor";
        public static final String createDatetime = "createDatetime";
        public static final String updateAuthor = "updateAuthor";
        public static final String updateDatetime = "updateDatetime";
    }
    
    /**
     * Constant declare: column name map with bean property.<br>
     */
    public static class ColumnName {
        public static final String ID = "ID";
        public static final String TITLE = "TITLE";
        public static final String ARTIST = "ARTIST";
        public static final String ISSUE_DATE = "ISSUE_DATE";
        public static final String GENRE = "GENRE";
        public static final String COVER_PHOTO = "COVER_PHOTO";
        public static final String CREATE_AUTHOR = "CREATE_AUTHOR";
        public static final String CREATE_DATETIME = "CREATE_DATETIME";
        public static final String UPDATE_AUTHOR = "UPDATE_AUTHOR";
        public static final String UPDATE_DATETIME = "UPDATE_DATETIME";
    }
    /**
     * Constant declare: table name.<br>
     */
    public static String TableName = "ALBUM";

}
