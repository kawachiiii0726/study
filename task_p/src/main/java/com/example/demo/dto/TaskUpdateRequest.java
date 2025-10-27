package com.example.demo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** タスク情報 更新リクエスト */
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskUpdateRequest extends TaskRequest implements Serializable {

    /** タスクID（必須） */
    @NotNull
    private Integer taskId;
}
