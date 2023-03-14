
function CheckAddProduct() {
	var productId = document.getElementById("productId");
	var name = document.getElementById("name");
	var unitPrice = document.getElementById("unitPrice");
	var unitsInStock = document.getElementById("unitsInStock");
	// 폼페이지에서 유효성 검사를 위한 입력 항목인 상품 아이디, 상품명, 가격, 재고 수 등의 id 속성값으로
	// 입력 데이터를 가져올 수 잇도록 getElementById() 메소드 작성
	// 만약 name 속성값 사용한다면 document.newProduct.productId.value; 로 들고와도됨

	//상품 아이디 체크
	if(!check(/^P[0-9]{4,11}$/, productId, 
		"[상품 코드] \nP와 숫자를 조합하여 5~12자까지 입력하세요\n 첫글자는 반드시 P로 시작하세요."))
		{
			return false;
		}
	
	//상품명 체크
	if(name.value.length < 4 || name.value.length > 12) {
		alert("[상품명] \n 최소 4자에서 최대 12자까지 입력하세요.");
		// 오류 메시지 출력.
		name.select(); 
		name.focus();
		// 설정 조건에 해당하지 않으면 입력 항목에 커서 놓음
		return false;
	}
	
	//상품 가격 체크
	if(unitPrice.value.length == 0 || isNaN(unitPrice.value)) {
		alert("[가격]\n숫자만 입력하세요.");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitPrice.value < 0) {
		alert("[가격]\n음수는 입력할 수 없습니다");
		unitPrice.select();
		unitPrice.focus();
		return false;
	} else if (!check(/^\d+(?:[.]?[\d]?[\d])?$/, unitPrice, 
			"[가격]\n소수점 둘째짜리까지만 입력하세요."))
		{
			return false;
		}

	// 재고 수 체크
	if(isNaN(unitsInStock.value)) {
		alert("[재고 수] \n 숫자만 입력하세요");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	//check() 함수 : 입력항목에 대해 정규 표현식으로 검사하여 오류가 있으면 오류메시지 출력
	// 해당 입력 항목에 커서가 놓이도록 check() 함수 작성
	function check(regExp, e, msg) {
		if(regExp.test(e.value)) {
			return true;
		}
		alert(msg);
		e.select();
		e.focus();
		return false;
	}
	document.newProduct.submit()
	// 폼 페이지에 입력된 데이터 값을 서버로 전송함.
}