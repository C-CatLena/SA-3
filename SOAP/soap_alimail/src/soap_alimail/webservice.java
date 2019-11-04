package soap_alimail;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

@WebService
public class webservice {
	
	public void send_mail( String address,String htmlbody) {
        // 濡傛灉鏄櫎鏉窞region澶栫殑鍏跺畠region锛堝鏂板姞鍧°�佹境娲睷egion锛夛紝闇�瑕佸皢涓嬮潰鐨�"cn-hangzhou"鏇挎崲涓�"ap-southeast-1"銆佹垨"ap-southeast-2"銆�
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FrBGButKUKLbfWFQGcV", "C9ozmjon8fqQjPiAhZys50GZfcODDJ");
        // 濡傛灉鏄櫎鏉窞region澶栫殑鍏跺畠region锛堝鏂板姞鍧egion锛夛紝 闇�瑕佸仛濡備笅澶勭悊
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 濡傛灉鏄櫎鏉窞region澶栫殑鍏跺畠region锛堝鏂板姞鍧egion锛�,蹇呴』鎸囧畾涓�2017-06-22
            request.setAccountName("wang@wangjifeng.work");
            request.setFromAlias("alitest");
            request.setAddressType(1);
            request.setTagName("tagwang");
            request.setReplyToAddress(true);
            request.setToAddress(address);
            //鍙互缁欏涓敹浠朵汉鍙戦�侀偖浠讹紝鏀朵欢浜轰箣闂寸敤閫楀彿鍒嗗紑锛屾壒閲忓彂淇″缓璁娇鐢˙atchSendMailRequest鏂瑰紡
            //request.setToAddress("閭1,閭2");
            request.setSubject("SA");
            request.setHtmlBody(htmlbody);
            //寮�鍚渶瑕佸妗堬紝0鍏抽棴锛�1寮�鍚�
            //request.setClickTrace("0");
            //濡傛灉璋冪敤鎴愬姛锛屾甯歌繑鍥瀐ttpResponse锛涘鏋滆皟鐢ㄥけ璐ュ垯鎶涘嚭寮傚父锛岄渶瑕佸湪寮傚父涓崟鑾烽敊璇紓甯哥爜锛涢敊璇紓甯哥爜璇峰弬鑰冨搴旂殑API鏂囨。;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            //鎹曡幏閿欒寮傚父鐮�
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            System.out.println("N");
        }
        catch (ClientException e) {
            //鎹曡幏閿欒寮傚父鐮�
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            System.out.println("N");
        }
        System.out.println("Y");
    }
	
	public void BatchSendMail() {
        // 濡傛灉鏄櫎鏉窞region澶栫殑鍏跺畠region锛堝鏂板姞鍧°�佹境娲睷egion锛夛紝闇�瑕佸皢涓嬮潰鐨�"cn-hangzhou"鏇挎崲涓�"ap-southeast-1"銆佹垨"ap-southeast-2"銆�
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FrBGButKUKLbfWFQGcV", "C9ozmjon8fqQjPiAhZys50GZfcODDJ");
        // 濡傛灉鏄櫎鏉窞region澶栫殑鍏跺畠region锛堝鏂板姞鍧egion锛夛紝 闇�瑕佸仛濡備笅澶勭悊
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 濡傛灉鏄櫎鏉窞region澶栫殑鍏跺畠region锛堝鏂板姞鍧egion锛�,蹇呴』鎸囧畾涓�2017-06-22
            request.setAccountName("wang@wangjifeng.work");
            request.setFromAlias("alitest");
            request.setAddressType(1);
            request.setTagName("tagwang");
            request.setReplyToAddress(true);
            request.setToAddress("zmw13377853677@163.com,1561937760@qq.com");
            //鍙互缁欏涓敹浠朵汉鍙戦�侀偖浠讹紝鏀朵欢浜轰箣闂寸敤閫楀彿鍒嗗紑锛屾壒閲忓彂淇″缓璁娇鐢˙atchSendMailRequest鏂瑰紡
            //request.setToAddress("閭1,閭2");
            request.setSubject("閭欢娴嬭瘯");
            request.setHtmlBody("娴嬭瘯鎴愬姛锛�");
            //寮�鍚渶瑕佸妗堬紝0鍏抽棴锛�1寮�鍚�
            //request.setClickTrace("0");
            //濡傛灉璋冪敤鎴愬姛锛屾甯歌繑鍥瀐ttpResponse锛涘鏋滆皟鐢ㄥけ璐ュ垯鎶涘嚭寮傚父锛岄渶瑕佸湪寮傚父涓崟鑾烽敊璇紓甯哥爜锛涢敊璇紓甯哥爜璇峰弬鑰冨搴旂殑API鏂囨。;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            //鎹曡幏閿欒寮傚父鐮�
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            System.out.println("N");
        }
        catch (ClientException e) {
            //鎹曡幏閿欒寮傚父鐮�
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            System.out.println("N");
        }
        System.out.println("Y");
    }
	
	public void check(String email) {
        if (email.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }
	
	public static void main(String[] args){
		//webservice鏈嶅姟鍣ㄥ彂甯冪殑鍦板潃
		String address = "http://localhost:8081/webservice"; //瀹氫箟8081绔彛
		//閫氳繃璇ユ柟娉曡繘琛屽彂甯�
		Endpoint.publish(address, new webservice());
		//鎵撳嵃涓�鍙ヨ瘽锛岃〃绀轰竴涓嬫湇鍔″櫒杩涜浜嗗紑鍚�
		System.out.println("my webservcie starting");
	}
}
