package com.sss.online.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author
 * @create 2019-05-29-11:02
 */
public class Md5Util {
    public static String getMd5(Object resource,Object salt){
        Md5Hash md5Hash = new Md5Hash(resource,salt);
        return md5Hash.toString();
    };
}
