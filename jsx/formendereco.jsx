import React from "react";

var FormularioEndereco = React.createClass({
    getInitialState(){
    	return {
    		enderecos: [],
    		rua:"",
    		bairro:"",
            telefone:"",
            pessoa:""
    	}
    },
    handleRuaChange(e){
    	this.setState({
    		rua:e.target.value
    	});
    },
    handleBairroChange(e){
    	this.setState({
    		bairro:e.target.value
    	});
    },
     handleTelefoneChange(e){
        this.setState({
            telefone:e.target.value
        });
    },
     handlePessoaChange(e){
        this.setState({
            pessoa:e.target.value
        });
    },
    handleButtonClick(){
    	var endereco = {
    		rua:this.state.rua,
    		bairro: this.state.bairro,
            telefone: this.state.telefone,
            pessoa: this.state.pessoa
    	}
		this.setState({ 
		    enderecos: this.state.enderecos.concat([endereco])
		});
    },
    render: function(){
     	return(
     		<div className="panel-body">
            <br />
	     	    <form className="formEnderecos">
                        <div className="input-group">
                            <span className="input-group-addon" id="basic-addon1">Rua</span>
                            <input type="text"  className="form-control" name="rua" placeholder="Ex.: Av. Silvio Menicucci" aria-describedby="basic-addon1"  onChange={this.handleRuaChange}/>
                        </div>
                        <br />
<div className="input-group">
                            <span className="input-group-addon" id="basic-addon1">Bairro</span>
                            <input type="text"  className="form-control" name="bairro" placeholder="Ex.: Centro" aria-describedby="basic-addon1"  onChange={this.handleBairroChange}/>
                        </div>                       
                        <br />
<div className="input-group">
                            <span className="input-group-addon" id="basic-addon1">Telefone</span>
                            <input type="text"  className="form-control" name="telefone" placeholder="Ex.: (35) 9 9999-9999" aria-describedby="basic-addon1"  onChange={this.handleTelefoneChange}/>
                        </div>
                        <br />
<div className="input-group">
                            <span className="input-group-addon" id="basic-addon1">Pessoa</span>
                            <input type="text"  className="form-control" name="pessoa" placeholder="Ex.: Fulano de Tal" aria-describedby="basic-addon1"  onChange={this.handlePessoaChange}/>
                        </div>
                        <br />
                    <div className="btn-group" role="group">
			         <input type="button"  className="btn btn-success" value="Cadastrar" onClick={this.handleButtonClick}/>
                    <a href="./#/" type="button" className="btn btn-default">Cancelar</a> 
                    </div>
	            </form>
                <br/>
	            {this.state.enderecos.map(endereco =>{
	            	return (
                       
	            		<div className="alert alert-info">
			            	<b>Rua: </b>{endereco.rua}<br />
			                <b>Bairro: </b>{endereco.bairro}<br />
                            <b>Telefone: </b>{endereco.telefone}<br />
                            <b>Pessoa: </b>{endereco.pessoa}
		                </div>
	                )
	            })
	            }
            </div>
     		);
     }
});

export default {
	FormularioEndereco: FormularioEndereco
};