package com.qh.api.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: Md5Util
 * @Description: md5加密
 * @author chyzh
 * @date 2017年10月25日 上午9:28:36
 *
 */
public class Md5Util {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Md5Util.class);

	public static String MD5(String content) {
		if (ParamUtil.isNotEmpty(content)) {
			try {
				return HexUtil.byte2hex(MessageDigest.getInstance("md5").digest(content.getBytes()));
			} catch (NoSuchAlgorithmException e) {
				logger.error("MD5加密错误！" + e.getMessage());
			}
		} else {
			logger.error("MD5加密内容为空！");
		}
		return null;
	}

	public static String SHA(String content) {
		if (ParamUtil.isNotEmpty(content)) {
			try {
				return HexUtil.byte2hex(MessageDigest.getInstance("SHA").digest(content.getBytes()));
			} catch (NoSuchAlgorithmException e) {
				logger.error("SHA加密错误！" + e.getMessage());
				throw new RuntimeException("SHA加密错误！" + e.getMessage());
			}
		} else {
			logger.error("SHA加密内容为空！");
		}
		return null;
	}

	public static String MD5Update(String content) {
		if (ParamUtil.isNotEmpty(content)) {
			MessageDigest messageDigest = null;
			try {
				messageDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				logger.error("MD5加密错误！" + e.getMessage());
				throw new RuntimeException("MD5加密错误！" + e.getMessage());
			}
			messageDigest.update(content.getBytes());
			return HexUtil.byte2hex(messageDigest.digest());
		} else {
			logger.error("MD5加密内容为空！");
		}
		return null;

	}

	public static String SHAUpdate(String content) {
		if (ParamUtil.isNotEmpty(content)) {
			MessageDigest messageDigest = null;
			try {
				messageDigest = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException e) {
				logger.error("SHA加密错误！" + e.getMessage());
				throw new RuntimeException("SHA加密错误！" + e.getMessage());
			}
			messageDigest.update(content.getBytes());
			return HexUtil.byte2hex(messageDigest.digest());
		} else {
			logger.error("SHA加密内容为空！");
		}
		return null;

	}
}