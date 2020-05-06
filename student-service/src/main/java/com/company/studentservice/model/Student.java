package com.company.studentservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@ApiModel(description = "All details about the Student  Entity. ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "The database generated employee ID")
    private int id;


    @ApiModelProperty(value ="Student name should not be less than 2")
    @NotBlank(message ="Name is mandatory")
    private String name;


    @ApiModelProperty(value ="Student surname have to min 5 character" )
    @NotBlank(message ="surname is mandatory")
    private String surname;

    @Min(value = 12, message = "Age should not be less than 18")
    @Max(value = 60, message = "Age should not be greater than 150")
    private int age;


    @ApiModelProperty(value ="Email format to be correct format" )
    @Column(unique = true)
    @Email(message = "MethodArgumentNotValidException")
    private String email;

}
