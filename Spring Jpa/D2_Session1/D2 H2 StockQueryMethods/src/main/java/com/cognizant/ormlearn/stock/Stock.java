package com.cognizant.ormlearn.stock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@Column(name = "st_id")
	private int id;

	@Column(name = "st_code")
	private String code;

	@Column(name = "st_date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(columnDefinition = "decimal", name = "st_open")
	private long open;

	@Column(columnDefinition = "decimal", name = "st_close")
	private long close;

	@Column(columnDefinition = "decimal", name = "st_volume")
	private long volume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getOpen() {
		return open;
	}

	public void setOpen(long open) {
		this.open = open;
	}

	public long getClose() {
		return close;
	}

	public void setClose(long close) {
		this.close = close;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", date=" + date + ", open=" + open + ", close=" + close
				+ ", volume=" + volume + "]";
	}

}
