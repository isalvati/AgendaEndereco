
import React from "react";
import Title from './title.jsx';
import FormEndereco from './formendereco.jsx';


var TitleBox = Title.TitleBox;
var FormularioEndereco = FormEndereco.FormularioEndereco;

export default React.createClass({
    render: function(){
    	return(
    		<div className="container">
                <div className="panel panel-primary">
    		      <TitleBox>
    		           Cadastro de Endereços
    		      </TitleBox>

            <br/>
            <FormularioEndereco />
            </div>
    		</div>
    	);
    }
});
