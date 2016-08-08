
import React from "react";
import Title from './title.jsx';
import FormPessoa from './formpessoa.jsx';


var TitleBox = Title.TitleBox;
var FormularioPessoa = FormPessoa.FormularioPessoa;

export default React.createClass({
    render: function(){
    	return(
    		<div className="container">
                <div className="panel panel-primary">
    		    <TitleBox>
    		       Cadastro de Pessoas
    		    </TitleBox>
                <br/>
            <FormularioPessoa />
    		</div>
            </div>
    	);
    }
});
