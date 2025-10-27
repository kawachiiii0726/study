package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 情報 リクエストデータ
 */
@Data
public class TaskRequest implements Serializable {
  /**
   * 名前
   */
	@NotEmpty(message = "タスク名を入力してください")
    @Size(max = 20, message = "タスク名は20文字以内で入力してください")
    private String taskName;

    /**
     * タスク状況
     */
    @NotEmpty(message = "タスク状況を入力してください")
    @Size(max = 20, message = "タスク状況は20文字以内で入力してください")
    private String taskStatus;

    /**
     * 開始日
     */
    private String startDate;

    /**
     * 終了日
     */
    private String endDate;
}	