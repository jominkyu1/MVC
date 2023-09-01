function join_check() {
  var $mem_pwd = $('#mem_pwd').val();
  var $pwd_chk = $('#pwd_chk').val();
  var $mem_name = $('#mem_name').val();
  var $mem_phone = $('#mem_phone').val();
  var $mem_email = $('#mem_email').val();

  if($.trim($('#mem_id').val()).length == 0){
    alert('아이디를 입력하세요');
    $('#mem_id').val('').focus();
    return false;
  }

  if ($mem_pwd !== $pwd_chk || $mem_pwd === '' || $pwd_chk === '') {
    alert('비밀번호가 일치하지 않습니다.');
    $('#pwd_chk').val('');
    $('#mem_pwd').val('').focus();
    return false;
  }

  if($mem_name == '' || $mem_phone == '' || $mem_email == ''){
    alert('회원가입 오류');
    return false;
  }  
} 