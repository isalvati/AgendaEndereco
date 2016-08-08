
import React from "react";

var TitleBox = React.createClass({
    render: function(){
     	return (
     		<div className="panel-heading" >
     		<h1 >
     		        {this.props.children}
     		</h1>
     		</div>
     	);
     }
});

export default {
	TitleBox: TitleBox
};