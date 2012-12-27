﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.18010
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WSClient.ServiceReference1 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://webservice.server/", ConfigurationName="ServiceReference1.MatchSvc")]
    public interface MatchSvc {
        
        // CODEGEN: Parameter 'return' requires additional schema information that cannot be captured using the parameter mode. The specific attribute is 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://webservice.server/MatchSvc/getMatchesRequest", ReplyAction="http://webservice.server/MatchSvc/getMatchesResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        WSClient.ServiceReference1.getMatchesResponse getMatches(WSClient.ServiceReference1.getMatchesRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://webservice.server/MatchSvc/getMatchesRequest", ReplyAction="http://webservice.server/MatchSvc/getMatchesResponse")]
        System.Threading.Tasks.Task<WSClient.ServiceReference1.getMatchesResponse> getMatchesAsync(WSClient.ServiceReference1.getMatchesRequest request);
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17929")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://webservice.server/")]
    public partial class matchresultWs : object, System.ComponentModel.INotifyPropertyChanged {
        
        private int idField;
        
        private System.DateTime dateField;
        
        private string hometeamField;
        
        private string foreignteamField;
        
        private double pointsHometeamField;
        
        private double pointsForeignteamField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public int id {
            get {
                return this.idField;
            }
            set {
                this.idField = value;
                this.RaisePropertyChanged("id");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public System.DateTime date {
            get {
                return this.dateField;
            }
            set {
                this.dateField = value;
                this.RaisePropertyChanged("date");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public string hometeam {
            get {
                return this.hometeamField;
            }
            set {
                this.hometeamField = value;
                this.RaisePropertyChanged("hometeam");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public string foreignteam {
            get {
                return this.foreignteamField;
            }
            set {
                this.foreignteamField = value;
                this.RaisePropertyChanged("foreignteam");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public double pointsHometeam {
            get {
                return this.pointsHometeamField;
            }
            set {
                this.pointsHometeamField = value;
                this.RaisePropertyChanged("pointsHometeam");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public double pointsForeignteam {
            get {
                return this.pointsForeignteamField;
            }
            set {
                this.pointsForeignteamField = value;
                this.RaisePropertyChanged("pointsForeignteam");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getMatches", WrapperNamespace="http://webservice.server/", IsWrapped=true)]
    public partial class getMatchesRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://webservice.server/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string arg0;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://webservice.server/", Order=1)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string arg1;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://webservice.server/", Order=2)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string arg2;
        
        public getMatchesRequest() {
        }
        
        public getMatchesRequest(string arg0, string arg1, string arg2) {
            this.arg0 = arg0;
            this.arg1 = arg1;
            this.arg2 = arg2;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getMatchesResponse", WrapperNamespace="http://webservice.server/", IsWrapped=true)]
    public partial class getMatchesResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://webservice.server/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public WSClient.ServiceReference1.matchresultWs[] @return;
        
        public getMatchesResponse() {
        }
        
        public getMatchesResponse(WSClient.ServiceReference1.matchresultWs[] @return) {
            this.@return = @return;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface MatchSvcChannel : WSClient.ServiceReference1.MatchSvc, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class MatchSvcClient : System.ServiceModel.ClientBase<WSClient.ServiceReference1.MatchSvc>, WSClient.ServiceReference1.MatchSvc {
        
        public MatchSvcClient() {
        }
        
        public MatchSvcClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public MatchSvcClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public MatchSvcClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public MatchSvcClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        WSClient.ServiceReference1.getMatchesResponse WSClient.ServiceReference1.MatchSvc.getMatches(WSClient.ServiceReference1.getMatchesRequest request) {
            return base.Channel.getMatches(request);
        }
        
        public WSClient.ServiceReference1.matchresultWs[] getMatches(string arg0, string arg1, string arg2) {
            WSClient.ServiceReference1.getMatchesRequest inValue = new WSClient.ServiceReference1.getMatchesRequest();
            inValue.arg0 = arg0;
            inValue.arg1 = arg1;
            inValue.arg2 = arg2;
            WSClient.ServiceReference1.getMatchesResponse retVal = ((WSClient.ServiceReference1.MatchSvc)(this)).getMatches(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<WSClient.ServiceReference1.getMatchesResponse> WSClient.ServiceReference1.MatchSvc.getMatchesAsync(WSClient.ServiceReference1.getMatchesRequest request) {
            return base.Channel.getMatchesAsync(request);
        }
        
        public System.Threading.Tasks.Task<WSClient.ServiceReference1.getMatchesResponse> getMatchesAsync(string arg0, string arg1, string arg2) {
            WSClient.ServiceReference1.getMatchesRequest inValue = new WSClient.ServiceReference1.getMatchesRequest();
            inValue.arg0 = arg0;
            inValue.arg1 = arg1;
            inValue.arg2 = arg2;
            return ((WSClient.ServiceReference1.MatchSvc)(this)).getMatchesAsync(inValue);
        }
    }
}
