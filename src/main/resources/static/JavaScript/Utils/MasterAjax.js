/*class MasterAjax{
	constructor(){
		this.requestType = null;
		this.url = null;
		this.timeout = 100000;
		this.enctype =  null;
		this.data = null;
		this.processData = null;
		this.contentType = null;
		this.responseData = null;
		this.responseStatus = null;
		this.responseStatusCode = null;
		this.xhrObject=null;
	}
	
	requestData(callBack){
		
		var parameterError=false;
		if(null == this.requestType){
			parameterError=true;
//			console.log("Error: Request Type can't be null");
		}    
		if(null === this.url || undefined === this.url || "undefined" === this.url){
			parameterError=true;
//			console.log("Error: URL can't be null");
		}  
		if(null == this.data || this.data.length <= 0){
//			console.log("Warning: Data is null");
		}
		if(parameterError === false){
//			toggleSpinnerOn();  
			this.xhrObject=$.ajax({
				type : this.requestType,
				enctype : this.enctype,
		        processData : this.processData, 
		        contentType : this.contentType, 
				url : global_contextPath+"/"+this.url,
				data: this.data,
				timeout : this.timeout,
				success : function(responseData,textStatus) {
//					toggleSpinnerOff();
					callBack(responseData,textStatus);
				},
				error : function(responseData,textStatus) {
//					toggleSpinnerOff();  
					callBack(responseData,textStatus); 
				}
			}); 
		}
		//return this.responseData;
	}
	
}
*/


class MasterAjax {
    constructor() {
        this.requestType = null;
        this.url = null;
        this.timeout = 100000;
        this.enctype = null;
        this.data = null;
        this.processData = true;
        this.contentType = 'application/json';
        this.responseData = null;
        this.responseStatus = null;
        this.responseStatusCode = null;
        this.xhrObject = null;
    }

    requestData(callBack) {
        let parameterError = false;

        if (this.requestType === null) {
            parameterError = true;
            console.error("Error: Request Type can't be null");
        }

        if (this.url === null || this.url === undefined || this.url === "undefined") {
            parameterError = true;
            console.error("Error: URL can't be null");
        }

        if (parameterError === false) {
            const options = {
                method: this.requestType,
                headers: {}
            };

            if (this.contentType !== false) {
                options.headers['Content-Type'] = this.contentType;
            }

            if (this.enctype) {
                options.headers['enctype'] = this.enctype;
            }

            if (this.data && (this.processData === undefined || this.processData === true)) {
                options.body = this.data instanceof FormData ? this.data : JSON.stringify(this.data);
            } else if (this.data) {
                options.body = this.data;
            }

            const controller = new AbortController();
            const timeoutId = setTimeout(() => controller.abort(), this.timeout);

            fetch(global_contextPath + "/" + this.url, { ...options, signal: controller.signal })
                .then(response => {
                    clearTimeout(timeoutId);
                    this.responseStatus = response.status;
                    this.responseStatusCode = response.statusText;
                    return response.json();
                })
                .then(data => {
                    this.responseData = data;
                    callBack(data, this.responseStatusCode);
                })
                .catch(error => {
                    if (error.name === 'AbortError') {
                        console.error('Request timed out');
                    } else {
                        console.error('Fetch error:', error);
                    }
                    callBack(null, this.responseStatusCode);
                });
        }
    }
}

