package com.spider.changyou;

import java.io.*;

/**
 * @author tianyi
 * @date 2019-07-27 20:26
 */
public class CmdUtil {

    // Python脚本所在目录
    private static final String PYTHON_SCRIPT_DIR_PATH = "C:\\Users\\Administrator\\Desktop";
    // Python脚本的完整文件名(包含后缀)
    private static final String PYTHON_SCRIPT_NAME = "getTokenId.py";

    /**
     * 调用 Python 脚本获取 tokenId
     * @param input_url 跳转前的链接地址
     * @return tokenId
     */
    public static String getTokenIdInPython(String input_url){

        // 初始化返回内容为""，若返回""，则说明失败了
        String rt = "";

        // 调用Python脚本的命令行指令
        String commandLine = "python3" + " " + PYTHON_SCRIPT_DIR_PATH + "\\" + PYTHON_SCRIPT_NAME +
                                         " " + input_url;

        // Java操作命令行的相关指令，这是windows系统的版本，Linux不确定是不是这样
        Process process = null;
        Runtime runtime = Runtime.getRuntime();

        try {
            // 执行指令
            process = runtime.exec(commandLine);

            // 获取结果 TODO 这里仅获取了正常运行的结果，错误信息的监听未实现
            String result = getCmdResult(process.getInputStream());
            if (result == "error") {
                System.out.println("获取cmd结果失败");
            } else if (result.indexOf("tokenId=") != -1){
                rt = result.substring(result.indexOf("tokenId=") + "tokenId=".length());
            } else {
                System.out.println("返回结果里没有tokenId");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rt;
    }

    /**
     * 获取命令行的执行结果
     * @param inputStream 命令行的输入流
     * @return 结果
     */
    private static String getCmdResult(InputStream inputStream) {
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream,"GB2312"));
            while( (line = bufferedReader.readLine()) != null ){
                sb.append(line);
                break;
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    // 运行测试
    public static void main(String[] args){
        // 输入样例
        String input_url = "https://m.changyoyo.com/event/2019/blankPage/index.html?interCode=CYS0001&character=00&ipAddress=MTQuMjMuMTM2LjE0&partnerId=S1000358&requestId=2019072721482329125366&reqTime=20190727214823&signType=MD5&type=mobile&version=MS4wLjA=&mobile=18320444515&outTokenId=18320444515&outType=00&callbackUrl=http%3A%2F%2F39.106.1.23%3A8080%2Fsms%2FcallbackUrl&channelSource=09000002&reserved1=16&reserved2=2&hmac=4368d3aad2d86a7a673add2892e171ad";
        // String input_url = "hello";

        // 获取结果，接口方法的调用示范
        String tokenId = CmdUtil.getTokenIdInPython(input_url);
        // 打印
        System.out.println(tokenId);
    }

}
