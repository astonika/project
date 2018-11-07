package com.company.project.sms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SmsTemplate {

	// 发送验证码的请求路径URL
	private String codeUrl = "https://api.netease.im/sms/sendcode.action";
	private String templateUrl = "https://api.netease.im/sms/sendtemplate.action";
	// 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
	private String appKey = "fd460d34e786e7754e505bc4fab0f027";
	// 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
	private String appSecret = "xxxxxxxx";
	private DefaultHttpClient httpClient = new DefaultHttpClient();

	/**
	 * @param nonce      随机数 nonce = "123456";
	 * @param templateId 短信模板ID templateId = "3057527";
	 * @param mobile     手机号 mobile = "13888888888";
	 * @param codeLen    验证码长度，范围4～10，默认为4 codelen = "6";
	 * @return
	 * @throws Exception
	 */
	public String sendCode(String nonce, String templateId, String mobile, String codeLen) throws Exception {

		HttpPost httpPost = new HttpPost(codeUrl);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		/*
		 * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
		 */
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);

		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的的参数，requestBody参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		/*
		 * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档” 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']" 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
		 */
		nvps.add(new BasicNameValuePair("templateid", templateId));
		nvps.add(new BasicNameValuePair("mobile", mobile));
		nvps.add(new BasicNameValuePair("codeLen", codeLen));

		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		/*
		 * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500 2.具体的code有问题的可以参考官网的Code状态表
		 */
//		System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));

		return EntityUtils.toString(response.getEntity(), "utf-8");

	}

	/**
	 * @param nonce
	 * @param templateId
	 * @param mobiles    手机号，接收者号码列表，JSONArray格式，限制接收者号码个数最多为100个 mobiles = "['13888888888','13666666666']";
	 * @param params     短信参数列表，用于依次填充模板，JSONArray格式，每个变量长度不能超过30字,对于不包含变量的模板，不填此参数表示模板即短信全文内容 params = "['xxxx','xxxx']";
	 * @return
	 * @throws Exception
	 */
	public String sendTemplate(String nonce, String templateId, String mobiles, String params) throws Exception {
		HttpPost httpPost = new HttpPost(templateUrl);
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		/*
		 * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
		 */
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);

		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的的参数，requestBody参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		/*
		 * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档” 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']" 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
		 */
		nvps.add(new BasicNameValuePair("templateid", templateId));
		nvps.add(new BasicNameValuePair("mobiles", mobiles));
		nvps.add(new BasicNameValuePair("params", params));

		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		/*
		 * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500 2.具体的code有问题的可以参考官网的Code状态表
		 */
//		System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));

		return EntityUtils.toString(response.getEntity(), "utf-8");
	}
}