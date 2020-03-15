# JSP-project-tiffany
## 1. 프로젝트 소개
https://mooo4030.blog.me/221791660101

## 2. DB

```sql
CREATE TABLE user (
  userno int(11) NOT NULL AUTO_INCREMENT,
  admin int(11) DEFAULT NULL,
  userid varchar(12) DEFAULT NULL,
  username varchar(12) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  address mediumtext,
  tel int(11) DEFAULT NULL,
  createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (userno),
  UNIQUE KEY userno_UNIQUE (userno),
  UNIQUE KEY userid_UNIQUE (userid)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8
```


```sql
CREATE TABLE product (
  productno int(11) NOT NULL AUTO_INCREMENT,
  type varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  productname text COLLATE utf8_unicode_ci,
  madeof text COLLATE utf8_unicode_ci,
  content text COLLATE utf8_unicode_ci,
  detail text COLLATE utf8_unicode_ci,
  images text COLLATE utf8_unicode_ci,
  PRIMARY KEY (productno)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci
```



```sql
CREATE TABLE notice (
  noticeno int(11) NOT NULL AUTO_INCREMENT,
  userno int(11) DEFAULT NULL,
  title varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  content mediumtext COLLATE utf8_unicode_ci,
  noticeCreateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (noticeno),
  KEY userno (userno),
  CONSTRAINT notice_ibfk_1 FOREIGN KEY (userno) REFERENCES user (userno)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci
```

```sql
CREATE TABLE comment (
  commentno int(11) NOT NULL AUTO_INCREMENT,
  userno int(11) DEFAULT NULL,
  noticeno int(11) DEFAULT NULL,
  content varchar(100) DEFAULT NULL,
  commentCreateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (commentno),
  KEY userno (userno),
  KEY comment_ibfk_2 (noticeno),
  CONSTRAINT comment_ibfk_1 FOREIGN KEY (userno) REFERENCES user (userno),
  CONSTRAINT comment_ibfk_2 FOREIGN KEY (noticeno) REFERENCES notice (noticeno) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8
```
