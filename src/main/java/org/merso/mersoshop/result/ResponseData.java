package org.merso.mersoshop.result;

import lombok.Data;
import org.merso.mersoshop.entity.ShopsSpecValue;

import java.util.List;

/**
 * ResponseData:
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
@Data
public class ResponseData<T> {

    /**
     * 统一返回码
     */
    public Integer code;

    /**
     * 统一错误消息
     */
    public String msg;

    /**
     * 结果对象
     */
    public T data;
    /**
     * 规格对象
     */
   public List<ShopsSpecValue> shopsSpecValues;

    public ResponseData() {
    }

    public ResponseData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(T data,List<ShopsSpecValue> shopsSpecValues){
        this.data = data;
        this.shopsSpecValues = shopsSpecValues;

    }

}

