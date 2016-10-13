package Model;

import ViewVO.MyCountryPreferenceViewVO;
import ViewVO.MyIngredientPreferenceViewVO;
import ViewVO.MyKindPreferenceViewVO;
import ViewVO.MyMethodPreferenceViewVO;

public class MessageGenerator {
	private String message;

	public MessageGenerator() {
		// TODO Auto-generated constructor stub
	}

	public MessageGenerator(String message) {
		this.message = message;
	}
	public String methodMessage(MyMethodPreferenceViewVO[] methodVOs){
		String methodName=null;
		int tempScore=0;
		for(int i=0;i<methodVOs.length;i++){
			if(tempScore<methodVOs[i].getScoreTotal()){
				tempScore=methodVOs[i].getScoreTotal();
				methodName=methodVOs[i].getMethodCategoryName();
			}
			
		}
		if(methodName.equals("Ƣ��")){
			 message="�ʹ� Ƣ��丮�� �����Ͻô°žƴϿ���??";
		}
		else{
			 message="����� "+methodName+"�ŴϾ�!!!!";
		}
		return message;
	}
	public String ingredientMessage(MyIngredientPreferenceViewVO[] ingredientVOs){
		String ingredientName=null;
		int tempScore=0;
		for(int i=0;i<ingredientVOs.length;i++){
			if(tempScore<ingredientVOs[i].getScoreTotal()){
				tempScore=ingredientVOs[i].getScoreTotal();
				ingredientName=ingredientVOs[i].getIngredientCategoryName();
			}
			
		}
		if(ingredientName.equals("ä�ҷ�")){
			 message="����� ��ġ���� ä�����ĸŴϾ�! 'ä����'";
		}
		else if(ingredientName.equals("����")) {
			 message="���� ��Ⱑ �ְ���?! ����� '�����'";
		}
		else if(ingredientName.equals("�ع���")) {
			 message="����� �ع��� �����Ͻó׿�! ����� '�ع���'";
		}
		else if(ingredientName.equals("��/�߰���")) {
			 message="����� ��/�߰����� �����Ͻó׿�! ����� '��/�߷���'";
		}
		else if(ingredientName.equals("���")) {
			 message="����� ����� �����Ͻó׿�! ����� '�����'";
		}
		else{
			message="����� ������?";
		}
		
		return message;
		
		
	}
	public String countryMessage(MyCountryPreferenceViewVO[] countryVOs){
		String countryName=null;
		int tempScore=0;
		for(int i=0;i<countryVOs.length;i++){
			if(tempScore<countryVOs[i].getScoreTotal()){
				tempScore=countryVOs[i].getScoreTotal();
				countryName=countryVOs[i].getCountryCategoryName();
			}
			
		}
		if(countryName.equals("�ѽ�")){
			 message="�԰Ÿ��߿��� �ѱ������� �ְ���!";
		}
		else if(countryName.equals("���")) {
			 message="���� ������������մϴ�!!";
		}
		else if(countryName.equals("�Ͻ�")) {
			 message="���� �Ϻ����������մϴ�!!";
		}
		else if(countryName.equals("�߽�")) {
			 message="���� �߽����������մϴ�!!";
		}
		else{
			message="����� ��������������?";
		}
		
		return message;
		
	}
	public String kindMessage(MyKindPreferenceViewVO[] kindVOs){
		String countryName=null;
		int tempScore=0;
		for(int i=0;i<kindVOs.length;i++){
			if(tempScore<kindVOs[i].getScoreTotal()){
				tempScore=kindVOs[i].getScoreTotal();
				countryName=kindVOs[i].getKindCategoryName();
			}
			
		}
		if(countryName.equals("��/��")){
			 message="����� Ȥ�� �䵹�̽Ű���?!";
		}
		else if(countryName.equals("��/����")) {
			 message="��丮�� �ʹ������Ͻø� ����ϴ�!!";
		}
		else if(countryName.equals("��/��/�")) {
			 message="��ū�� ���� ����!!!!";
		}
		else if(countryName.equals("��ġ/�ع���")) {
			 message="���� �������� ���� �߿�����!";
		}
		else{
			message="����� ��������������?";
		}
		
		return message;
		
	}

}
