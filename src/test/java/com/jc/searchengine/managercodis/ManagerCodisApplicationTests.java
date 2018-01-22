package com.jc.searchengine.managercodis;

import com.jc.searchengine.managercodis.shell.RemoteShellExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qinsf
 * @date 2018年01月19日13:26:23
 * @version v.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerCodisApplicationTests {

    /** 远程就写远程的ip，本地 localhost 或者 127.0.0.1 */
    private static final String IP = "localhost";

    /** 主机用户名 */
    private static final String USER_NAME = "qinshaofeng";

    /** 用户名密码 */
    private static final String PASSWORD = "15831819519qq";

    /** 放代码的工作空间路径 */
    private static final String WORK_SPACE_PATH = " "+"/Users/qinshaofeng/Downloads/geode";

    /** frep命令所在路径 */
    private static final String FREP_PATH = "/usr/local/bin/frep"+" ";

    /** template路径，不需要修改 */
    private static final String TEMPLATET_PATH = WORK_SPACE_PATH + "/manager-codis/src/main/resources/template";

    /** paddingdata路径，不需要修改 */
    private static final String PADDING_DATA_PATH = WORK_SPACE_PATH + "/manager-codis/src/main/resources/paddingdata";

    /**
	 * 创建dashboard配置文件
	 * @throws Exception
	 */
	@Test
	public void generateDashBoardConfig() throws Exception{
		RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1路径不对！"+executor.exec("#!/bin/bash\n" +
                 ""+ FREP_PATH + ""+ TEMPLATET_PATH +
                "/dashboard/dashboard.toml.in --load " + PADDING_DATA_PATH +
                "/dashboard/dashboard.yml --overwrite\n"));
	}

	/**
	 * 创建proxy配置文件
	 * @throws Exception
	 */
	@Test
	public void generateProxy1Config() throws Exception{
        RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1路径不对！"+executor.exec("#!/bin/bash\n" +
                "" + FREP_PATH + "" + TEMPLATET_PATH +
                "/proxy/proxy.toml.in --load" + PADDING_DATA_PATH +
                "/proxy/proxy.yml --overwrite\n"));
	}


	/**
	 * 创建redis配置文件
	 * @throws Exception
	 */
	@Test
	public void generateRedisConfig() throws Exception{
        RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1a路径不对！"+executor.exec("#!/bin/bash\n" +
                ""+FREP_PATH+""+TEMPLATET_PATH+
                "/redis/redis.conf.in --load" + PADDING_DATA_PATH +
                "/redis/redis.yml --overwrite\n"));
	}

	/**
	 * 创建sentinel配置文件
	 * @throws Exception
	 */
	@Test
	public void generateSentinelConfig() throws Exception{
        RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1路径不对！"+executor.exec("#!/bin/bash\n" +
                "" + FREP_PATH + "" + TEMPLATET_PATH +
                "/sentinel/sentinel.conf.in --load"+PADDING_DATA_PATH+
                "/sentinel/sentinel.yml --overwrite\n"));
	}

    /**
     * 创建脚本1执行文件(codis_dash_fe_proxy_redis)
     * @throws Exception
     */

	@Test
    public void generateSH11111() throws Exception{
        RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1路径不对！"+executor.exec("#!/bin/bash\n" +
                "" + FREP_PATH + "" + TEMPLATET_PATH +
                ".shell.shell_1/codis_dash_fe_proxy_redis.sh.in --load"+PADDING_DATA_PATH+
                ".shell.shell_1/codis_dash_fe_proxy_redis.yml --overwrite\n"));
    }
    /**
     * 创建脚本2执行文件(codis_proxy_redis)
     * @throws Exception
     */
    @Test
    public void generateSH22222() throws Exception{
        RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1路径不对！"+executor.exec("#!/bin/bash\n" +
                "" + FREP_PATH + "" + TEMPLATET_PATH +
                ".shell.shell_2/codis_proxy_redis.sh.in --load"+PADDING_DATA_PATH+
                ".shell.shell_2/codis_proxy_redis.yml --overwrite\n"));
    }

    /**
     * 创建脚本3执行文件(codis_sentinel)
     * @throws Exception
     */
    @Test
    public void generateSH33333() throws Exception{
        RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1路径不对！"+executor.exec("#!/bin/bash\n" +
                "" + FREP_PATH + "" + TEMPLATET_PATH +
                ".shell.shell_3/codis_sentinel.sh.in --load"+PADDING_DATA_PATH+
                ".shell.shell_3/codis_sentinel.yml --overwrite\n"));
    }

    /**
     * 这个是后期添加redis实例用到的脚本，动态扩展
     * @throws Exception
     */
    @Test
    public void generateAddRedisSH() throws Exception{
        RemoteShellExecutor executor = new RemoteShellExecutor(IP, USER_NAME, PASSWORD);
        System.out.println("返回0成功！返回127失败！返回126拒绝！返回1路径不对！"+executor.exec("#!/bin/bash\n" +
                "" + FREP_PATH + "" + TEMPLATET_PATH +
                "/shell/add/redis/codis_add_redis.sh.in --load"+PADDING_DATA_PATH+
                "/shell/add/redis/addRedis.yml --overwrite\n"));
    }
}