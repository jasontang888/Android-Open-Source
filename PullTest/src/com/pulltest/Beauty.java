package com.pulltest;

public class Beauty {
	
	//��Ů����
	private String name;
	//��Ů����
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "��Ů���� [����=" + age + ", ����=" + name + "]";
	}
}
