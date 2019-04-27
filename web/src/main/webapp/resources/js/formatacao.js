function replaceAll(string, token, newtoken) {
	while (string.indexOf(token) != -1) {
		string = string.replace(token, newtoken);
	}
	return string;
}

			function formatacaoCNPJ(cnpj) {

				cnpj = cnpj.value;
				cnpj = cnpj.toString();

				cnpj = replaceAll(cnpj, ".", "");
				cnpj = replaceAll(cnpj, "_", "");
				cnpj = replaceAll(cnpj, "/", "");
				cnpj = replaceAll(cnpj, "-", "");

				if(cnpj != "" && cnpj.length <= 8 ) {
					cnpj = padLeft(cnpj, "0", 8);
				}
				return cnpj;
			}


			function padLeft(val, ch, num) {
				var re = new RegExp(".{" + num + "}$");
				var pad = "";
				if (!ch) ch = " ";
					do  {
						pad += ch;
					}
					while(pad.length < num);

				return re.exec(pad + val)[0];
			}