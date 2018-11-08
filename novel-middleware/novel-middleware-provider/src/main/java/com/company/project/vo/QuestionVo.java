package com.company.project.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class QuestionVo implements Serializable {
	@Field
	private Integer id;

	@Field
	private String title;

	@Field
	private String content;

	@Field("create_time")
	private Date createTime;

	@Field("update_time")
	private Date updateTime;

	@Field("_version_")
	private long version;

	@Field("score")
	private double score;

	@Field("tags")
	private String[] tags;

	@Field
	List<String> features;

	private String[] categories;


	@Field("scores")
	public void setScore(String[] c) {
		this.categories = c;
	}

	private static final long serialVersionUID = 1L;
}