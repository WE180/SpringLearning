package com.we.springboot.excel.handler;


import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.alibaba.fastjson.JSON;
import com.we.springboot.excel.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sudingkun
 */
public class MapImportHandler extends ExcelDataHandlerDefaultImpl<Map<String, Object>> {
    public MapImportHandler() {
    }

    public MapImportHandler(String startColumn, String endColumn) {
        this.startColumn = startColumn;
        this.endColumn = endColumn;
    }

    private String startColumn = Constants.Bill.PAYMENT_DATE;
    private String endColumn = Constants.Bill.TOTAL;

    private static Boolean TAG = Boolean.FALSE;

    private HashMap<String, Object> hashMap = new HashMap<>();

    @Override
    public void setMapValue(Map<String, Object> map, String originKey, Object value) {
        if (endColumn.equals(originKey)) {
            TAG = Boolean.FALSE;
        }

        if (TAG) {
            hashMap.put(originKey, value);
            String jsonString = JSON.toJSONString(hashMap);
            originKey = Constants.COLUMN;
            value = jsonString;
        }

        if (startColumn.equals(originKey)) {
            TAG = Boolean.TRUE;
        }

        switch (originKey) {
            case Constants.Bill.NAME:
                originKey = "name";
                break;
            case Constants.Bill.PHONE:
                originKey = "phone";
                break;
            case Constants.Bill.PAYMENT_DATE:
                originKey = "paymentDate";
                break;
            case Constants.Bill.TOTAL:
                originKey = "total";
                break;
            case Constants.COLUMN:
                break;
            default:
                throw new IllegalStateException("excel列名错误 {}" + originKey);
        }

        map.put(originKey, value);
    }


}