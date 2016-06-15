package imc.servlet;

public class imcServletModel
{
	public static String calcularIMC(float peso, float altura)
	{
		float imc = 0;
		String resultado = null;

		if ((peso != 0) && (altura != 0))
		{
			imc = peso / (altura*altura);		
			if (imc < 18.5){resultado = "abaixo do peso";}
			if ((imc >= 18.5) && (imc < 25)){resultado = "peso normal";}
	    	if ((imc >= 25) && (imc < 30)){resultado = "sobrepeso";}     
	    	if ((imc >= 30) && (imc < 40)){resultado = "obesidade";}
	    	if (imc > 40){resultado = "obesidade mórbida";}
		}
		else{resultado = "";}
	    
		return resultado;
	}   	
}
