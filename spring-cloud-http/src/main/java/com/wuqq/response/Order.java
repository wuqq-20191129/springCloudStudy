package com.wuqq.response;

/**
 * @author: wuqq
 * @date: 2021/8/2 9:46 PM
 * @version: 1.0
 */

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class Order {
    private String taskId;

    private String clientId;

    private List<String> sheetIds;

    public void setTaskId(String taskId){
        this.taskId = taskId;
    }
    public String getTaskId(){
        return this.taskId;
    }
    public void setClientId(String clientId){
        this.clientId = clientId;
    }
    public String getClientId(){
        return this.clientId;
    }
    public void setSheetIds(List<String> sheetIds){
        this.sheetIds = sheetIds;
    }
    public List<String> getSheetIds(){
        return this.sheetIds;
    }
}



