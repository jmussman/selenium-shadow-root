class HelloWorld extends HTMLElement {

	connectedCallback() {
	
		const shadow = this.attachShadow({ mode: 'open' });
	
		const div = document.createElement('div');
		
		div.id = 'hello';
		div.classList.add('orange');
		div.innerHTML = "Hello, World!";
		
		shadow.appendChild(div);
	}
}

window.customElements.define('hello-world', HelloWorld);