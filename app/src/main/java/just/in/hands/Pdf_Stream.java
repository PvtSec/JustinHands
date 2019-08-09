package just.in.hands;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by phoenix on 20/8/17.
 */

class Pdf_Stream extends Request<byte[]> {
    private final Response.Listener<byte[]> mListener;
    private Map<String, String> mParams;

    //create a static map for directly accessing headers
    public Map<String, String> responseHeaders ;

    public Pdf_Stream(int method, String mUrl ,Response.Listener<byte[]> listener,
                                    Response.ErrorListener errorListener, HashMap<String, String> params) {
        super(Method.GET, mUrl, errorListener);
        // this request would never use cache.
        setShouldCache(false);
        mListener = listener;
        mParams=params;
    }

    @Override
    protected Map<String, String> getParams()
            throws com.android.volley.AuthFailureError
    {
        return mParams;
    }
    @Override
    protected void deliverResponse(byte[] response)
    {
        mListener.onResponse(response);
    }
    @Override
    protected Response<byte[]> parseNetworkResponse(NetworkResponse response)
    {
        responseHeaders = response.headers;
        return Response.success( response.data, HttpHeaderParser.parseCacheHeaders(response));
    }
}