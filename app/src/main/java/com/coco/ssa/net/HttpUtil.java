package com.coco.ssa.net;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;
import com.yanzhenjie.nohttp.rest.StringRequest;
import com.coco.ssa.util.ProgressDialogUtil;
import com.coco.ssa.util.ToastUtil;

/**
 * Created by cod on 2018/1/22.
 */

public class HttpUtil {

    private static HttpUtil instance;

    public static HttpUtil getInstance() {
        if (instance == null)
            synchronized (HttpUtil.class) {
                if (instance == null)
                    instance = new HttpUtil();
            }
        return instance;
    }

    private RequestQueue queue;

    private HttpUtil() {
        queue = NoHttp.newRequestQueue(10);
    }

        public <T> void request(int what, Request<T> request, SimpleResponseListener<T> listener) {
            queue.add(what, request, listener);
        }

    /**
     * @param what
     * @param request
     * @param listener
     */
    public void request(int what, Request<String> request, OnResultListener<String> listener) {
        queue.add(what, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                super.onSucceed(what, response);
                listener.onResult(what, response.get());
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                super.onFailed(what, response);
                ToastUtil.show("网络连接有问题");
                ProgressDialogUtil.dismiss();
            }
        });
    }


    /**
     * 常用的get请求
     * @param url
     * @param listener
     */
    public void get(String url ,OnResultListener<String> listener){
        int random = (int)Math.random()*1000;
        queue.add(random, new StringRequest(url, RequestMethod.GET), new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                super.onSucceed(what, response);
                if(what==random){
                    listener.onResult(what,response.get());
                }
            }
        });
    }

    // 完全退出app时，调用这个方法释放CPU。
    public void stop() {
        queue.stop();
    }

    public interface OnResultListener<T> {
        void onResult(int what, T result);
    }
}
