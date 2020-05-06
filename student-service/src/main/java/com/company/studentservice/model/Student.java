package com.company.studentservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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


    @ApiModelProperty(value ="Student name have to min 3 character")
    private String name;


    @ApiModelProperty(value ="Student surname have to min 5 character" )
    private String surname;

    private int age;


    @ApiModelProperty(value ="Email format to be correct format" )
    @Column(unique = true)
    private String email;

}
