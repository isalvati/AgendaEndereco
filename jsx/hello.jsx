
import React from "react";
import Title from './title.jsx';
import FormEndereco from './formendereco.jsx';
import FormPessoa from './formpessoa.jsx';

var TitleBox = Title.TitleBox;
var FormularioEndereco = FormEndereco.FormularioEndereco;
var FormularioPessoa = FormPessoa.FormularioPessoa;

/*var CommentBox = React.createClass({
  render: function() {
    return (
      <div className="commentBox">
        Hello, world! I am a CommentBox.
      </div>
    );
  }
});*/

export default React.createClass({
    render: function(){
    	return(
    		<div className="bodyBox">
    		    <TitleBox corLetra="black">
    		        Bem vindo a agenda
    		    </TitleBox>
          
    		  </div>
    	);
    }
});

