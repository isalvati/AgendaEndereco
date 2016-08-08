
import React from "react";
import Title from './title.jsx';

var TitleBox = Title.TitleBox;

export default React.createClass({
  render: function() {
    return (
      <div className="container">
                <div className="panel panel-primary">
			     	 <TitleBox>
    		       		Bem vindo a Agenda de Endereços
    		    	</TitleBox>
			        <div className="panel-body">
				        <ul className="nav nav-pills nav-stacked">
						  <li role="presentation" ><a href="./#/enderecos">Cadastro de Endereços</a><br/></li>
						  <li role="presentation" ><a href="./#/pessoas">Cadastro de Pessoas</a><br/></li>
						</ul>
		        	</div>
      			</div>
      </div>
    );
  }
});
