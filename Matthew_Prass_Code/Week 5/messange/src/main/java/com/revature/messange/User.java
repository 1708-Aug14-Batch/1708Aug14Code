package com.revature.messange;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {


		@Id
		@Column(name="user_ID")
		@SequenceGenerator(name = "user_ID_SEQ", sequenceName="user_ID_SEQ")
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_ID_SEQ")
		private int id;
		
		@Column(nullable=false)
		private String name;
		public User() {
			
		}
		public User(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
		
		
}

