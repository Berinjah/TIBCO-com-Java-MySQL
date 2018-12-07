package view;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;
import report.AlunoREL;

public class AlunosExec {

	public static void main(String[] args) {
		Alunos alunos = new Alunos();
		try {
			
			List<Alunos> alunoslist = new ArrayList<Alunos>();
			
			alunos.setId("5");
			alunos.setNome("Carlos Cardoso");
			alunos.setEndereco("Av Águia de Haia, 2600");
			alunos.setBairro("Jd São Nicolau");
			alunos.setCep("3811111");
			
			alunoslist.add(alunos);
			
			Connection connection = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			alunosJdbcDao.salvar(alunos);
			//alunosJdbcDao.deletar(2);
			//alunosJdbcDao.alterar(alunos, 2);
			alunosJdbcDao.listar();
			
			AlunoREL relatorio = new AlunoREL();
			relatorio.imprimir(alunoslist);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
