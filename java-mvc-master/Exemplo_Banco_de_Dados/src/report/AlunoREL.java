package report;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

import model.Alunos;

public class AlunoREL {
	
	private String path; // Caminho base

	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

	// Recupera os caminhos para que a classe possa encontrar os relatórios
	public AlunoREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "report/";
		System.out.println(path);
	}

	// Imprime/gera uma lista de Clientes
	public void imprimir(List<Alunos> alunos) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Alunos.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(alunos));

		JasperExportManager.exportReportToPdfFile(print, "D:/Relatorio_de_Alunos.pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}

}
