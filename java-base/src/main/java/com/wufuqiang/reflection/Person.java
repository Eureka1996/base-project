package com.wufuqiang.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	private String name;
	private int age;

	private Person(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("I'm a person.");
	}

	public String showNation(String nation){
		System.out.println("My nation is "+nation);
		return nation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
