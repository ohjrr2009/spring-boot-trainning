package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMethodOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumericFormatChecker.isNumeric(numberOne) || !NumericFormatChecker.isNumeric(numberTwo)) {
			throw new UnsupportedMethodOperationException("Please set a numeric value!!!");
		}
		
		Double sum = NumericFormatChecker.convertToDouble(numberOne) + NumericFormatChecker.convertToDouble(numberTwo);
		
		return sum;
	}
	
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumericFormatChecker.isNumeric(numberOne) || !NumericFormatChecker.isNumeric(numberTwo)) {
			throw new UnsupportedMethodOperationException("Please set a numeric value!!!");
		}
		
		Double sub = NumericFormatChecker.convertToDouble(numberOne) - NumericFormatChecker.convertToDouble(numberTwo);
		
		return sub;
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumericFormatChecker.isNumeric(numberOne) || !NumericFormatChecker.isNumeric(numberTwo)) {
			throw new UnsupportedMethodOperationException("Please set a numeric value!!!");
		}
		
		if (NumericFormatChecker.convertToDouble(numberTwo) == 0D) {
			throw new UnsupportedMethodOperationException("DIV by 0 not allowed!!! Please, choose another number!");
		}
		
		Double div = NumericFormatChecker.convertToDouble(numberOne)/NumericFormatChecker.convertToDouble(numberTwo);
		
		return div;
	}
	
	@RequestMapping(value="/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumericFormatChecker.isNumeric(numberOne) || !NumericFormatChecker.isNumeric(numberTwo)) {
			throw new UnsupportedMethodOperationException("Please set a numeric value!!!");
		}
		
		Double mul = NumericFormatChecker.convertToDouble(numberOne) * NumericFormatChecker.convertToDouble(numberTwo);
		
		return mul;
	}
	
	@RequestMapping(value="/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		if (!NumericFormatChecker.isNumeric(numberOne) || !NumericFormatChecker.isNumeric(numberTwo)) {
			throw new UnsupportedMethodOperationException("Please set a numeric value!!!");
		}
		
		Double avg = (NumericFormatChecker.convertToDouble(numberOne) + NumericFormatChecker.convertToDouble(numberTwo))/2;
		
		return avg;
	}
	
	@RequestMapping(value="/sqrt/{numberOne}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne) {
		if (!NumericFormatChecker.isNumeric(numberOne)) {
			throw new UnsupportedMethodOperationException("Please set a numeric value!!!");
		}
		
		if (NumericFormatChecker.convertToDouble(numberOne) < 0D) {
			throw new UnsupportedMethodOperationException("Square Root from negative numbers not allowed!!! Please, choose another number!");
		}
		
		Double sqrt = Math.sqrt(NumericFormatChecker.convertToDouble(numberOne));
		
		return sqrt;
	}
}
