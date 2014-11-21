/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.upasx.lichee.client.utils.PathUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class PathUtilsTest {

	@Test
	public void testJoin() {
		assertEquals("/", PathUtils.join());
		assertEquals("/", PathUtils.join("", ""));
		assertEquals("/", PathUtils.join("/", ""));
		assertEquals("/", PathUtils.join("/", "/"));
		assertEquals("/", PathUtils.join("/", null));

		assertEquals("/abc/cde/abc", PathUtils.join("/", "abc", "cde", "abc"));
		assertEquals("/abc/bcd/cde/def/abc",
				PathUtils.join("/abc/bcd", "cde/def", "abc"));
		assertEquals("/abc/cde/abc",
				PathUtils.join("/", "abc/", "/cde/", "/abc/"));
		assertEquals("/abc/cde/abc",
				PathUtils.join("/", "abc/", "/cde/", "/abc"));
		assertEquals("/abc/cde/abc",
				PathUtils.join("/", null, "", "/", "abc/", "/cde/", "/abc"));
	}

}
