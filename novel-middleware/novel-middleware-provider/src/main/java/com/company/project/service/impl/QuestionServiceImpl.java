package com.company.project.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;

import com.company.project.vo.QuestionVo;

public class QuestionServiceImpl {

//	private SolrClient solrClient = new CloudSolrClient("");
	private HttpSolrClient httpSolrClient = new HttpSolrClient("http://localhost:8082/solr/core1");
//	private CloudSolrClient solrClient = new CloudSolrClient("");

	public static void main(String[] args) throws Exception {
		new QuestionServiceImpl().sss();

	}

	private void sss() throws Exception {
//		ModifiableSolrParams modifiableSolrParams = new ModifiableSolrParams();
//		modifiableSolrParams.set("command", "delta-import");
//		QueryRequest queryRequest = new QueryRequest(modifiableSolrParams);
//		http://localhost:8080/solr/core1/select?q=id:*
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q", "id:*");
		solrQuery.setIncludeScore(true);
		solrQuery.setStart(0);
		solrQuery.setRows(3);
		System.out.println(solrQuery);
		QueryResponse queryResponse = httpSolrClient.query(solrQuery);
		SolrDocumentList results = queryResponse.getResults();
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.getFieldValue("title"));
		}
		List<QuestionVo> beans = queryResponse.getBeans(QuestionVo.class);
		System.out.println(results);
		System.out.println(beans);
		
//		httpSolrClient.query(modifiableSolrParams);
	}

	public void foobar() throws Exception {
		ModifiableSolrParams modifiableSolrParams = new ModifiableSolrParams();
		modifiableSolrParams.set("command", "delta-import");
		QueryRequest queryRequest = new QueryRequest(modifiableSolrParams);
		queryRequest.setPath("/dataimport");
		httpSolrClient.request(queryRequest);
	}
}
