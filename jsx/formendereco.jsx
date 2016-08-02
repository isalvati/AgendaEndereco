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
     		<div className="formBox">
            <br />
	     	    <form className="formEnderecos">
                    <label htmlFor="rua">Rua: </label>
			        <input type="text" 
			            placeholder="Ex: Av. Silvio Menicucci" 
                        name="rua"
	                    onChange={this.handleRuaChange} /><br /><br />
                    <label htmlFor="bairro">Bairro: </label>
			        <input type="text" 
			            placeholder="Ex: Centro"
                        name="bairro"
			            onChange={this.handleBairroChange} /><br /><br />
                     <label htmlFor="telefone">Telefone: </label>
                    <input type="text" 
                        placeholder="Ex: (35) 9 9999-9999"
                        name="telefone"
                        onChange={this.handleTelefoneChange} /><br /><br />
                    <label htmlFor="pessoa">Pessoa: </label>
                    <input type="text" 
                        placeholder="Ex: Fulano de Tal"
                        name="pessoa"
                        onChange={this.handlePessoaChange} /><br /><br />
			        <input type="button" value="Cadastrar" onClick={this.handleButtonClick}/><br /><br />
	            </form>
	            {this.state.enderecos.map(endereco =>{
	            	return (
	            		<div className="enderecoBox">
			            	Rua:{endereco.rua}<br />
			                Bairro:{endereco.bairro}<br />
                            Telefone:{endereco.telefone}<br />
                            Pessoa:{endereco.pessoa}<br /><br />
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