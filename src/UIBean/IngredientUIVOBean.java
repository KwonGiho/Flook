package UIBean;
/**
 * ������ ���� ���� ���Դϴ�.
 * UIBean����� modify�����༭ ��
 * ���߿� �����ϰ� �����丵 �Ͻʼ�.
 * ���ش� Ŭ���� API�ۼ��ڴ� �����鿡�� API�ּ� �����ϱ� ���� �� ����� �뺸�Ұ�.
 * @author GHKwon
 *
 */
public class IngredientUIVOBean extends IngredientUIBean{
	private String ingredientName;
	private int ingredientAmount;
	private String ingredientUnit;
	private String ingredientCode;
	public IngredientUIVOBean() {
		super();
	}
	public IngredientUIVOBean(String ingredientName, int ingredientAmount,
			String ingredientUnit, String ingredientCode) {
		super();
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnit = ingredientUnit;
		this.ingredientCode = ingredientCode;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public int getIngredientAmount() {
		return ingredientAmount;
	}
	public void setIngredientAmount(int ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}
	public String getIngredientUnit() {
		return ingredientUnit;
	}
	public void setIngredientUnit(String ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}
	public String getIngredientCode() {
		return ingredientCode;
	}
	public void setIngredientCode(String ingredientCode) {
		this.ingredientCode = ingredientCode;
	}
	@Override
	public String toString() {
		return "IngredientUIVOBean [ingredientName=" + ingredientName
				+ ", ingredientAmount=" + ingredientAmount
				+ ", ingredientUnit=" + ingredientUnit + ", ingredientCode="
				+ ingredientCode + "]";
	}
	
}
