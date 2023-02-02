package model;

import java.util.Date;

public class Employee {

	private Integer empNo;
	private String apellido;
	private String oficio;
	private Integer dir;
	private Date fechaAlta;
	private Float salario;
	private Float comision;
	private Integer deptNo;
	
	public Employee() {}
	
	public Employee(Integer empNo, String apellido, String oficio, Integer dir, Date fechaAlta, Float salario,
			Float comision, Integer deptNo) {
		super();
		this.empNo = empNo;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
		this.deptNo = deptNo;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public Integer getDir() {
		return dir;
	}
	public void setDir(Integer dir) {
		this.dir = dir;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	public Float getComision() {
		return comision;
	}
	public void setComision(Float comision) {
		this.comision = comision;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", apellido=" + apellido + ", oficio=" + oficio + ", dir=" + dir
				+ ", fechaAlta=" + fechaAlta + ", salario=" + salario + ", comision=" + comision + ", deptNo=" + deptNo
				+ "]";
	}
}
