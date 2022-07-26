package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/altaEmpleado")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmpleadoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String provincias=request.getParameter("provincias");
		String[] Conocimientos=request.getParameterValues("Conocimientos[]");
		String fecha=request.getParameter("fecha_nac");
		Integer experiencia=Integer.parseInt(request.getParameter("experiencia"));
		
		UtilidadesServlet.imprimirCabecera("Datos del empleado",out);
		out.println("<h1>Datos introducidos: \n </h1>");
		out.println("<ul>");
		out.println("<li>Nombre: "+nombre+"</li>");
		out.println("<li>Apellidos: "+apellidos+"</li>");
		out.println("<li>Provincias: "+provincias+"</li >");
		out.println("<li>Conocimientos: ");
		
		if (Conocimientos== null || Conocimientos.length==0){
			out.print("No se han registrado conocimientos.</li>");	
				
		}else {
			out.println("<ul>");
			for (String c : Conocimientos) {
				out.println("<li>"+c+"</li> ");
			}
			out.println("</ul>");
			out.println("</li>");
		}
				
		out.println("<li>Fecha de nacimiento: "+fecha+"</li> ");
		out.println("<li>Experiencia(años): "+experiencia+"</li> ");
		out.println("</ul>");
		
		UtilidadesServlet.imprimirPie(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
