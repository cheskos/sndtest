package com.evite.giphytest.base;

import android.support.annotation.NonNull;
import android.util.Log;
import com.evite.giphytest.utils.ArraysUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.evite.giphytest.ExtensionsKt.populateThrowable;

public class BaseApiCallback<T> implements Callback<T> {

    public interface Success<T> {
        void onSuccess(T body);
    }

    public interface Failure {
        void onFailure(Throwable t);
    }

    private static final int[] SUCCESS_CODES = {200, 201, 204};
    private Success<T> success;
    private Failure failure;

    public BaseApiCallback(Success<T> success, Failure failure) {
        this.success = success;
        this.failure = failure;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (success != null) {
            if (ArraysUtils.contains(SUCCESS_CODES, response.code())) {
                success.onSuccess(response.body());
            } else {
                failure.onFailure(populateThrowable(response));
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        if (call.isCanceled()) {
            Log.d("BaseApiCallback", "OkHttp REQUEST WAS CANCELLED");
        } else {
            failure.onFailure(t);
        }
    }
}