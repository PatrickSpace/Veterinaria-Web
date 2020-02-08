    window.addEventListener('load', () => {
            const preloader = document.querySelector('#cload');
            preloader.classList.add("load-finish");
        })
        
   
        function getHora() {
            var hoy = new Date();
            var horas = hoy.getHours();
            var minutos = hoy.getMinutes();
            var segundos = hoy.getSeconds();
            var dia = hoy.getUTCDate();
            var mes = hoy.getUTCMonth() + 1;
            var year = hoy.getUTCFullYear();
            horas = ajustar(horas);
            minutos = ajustar(minutos);
            segundos = ajustar(segundos);
            document.getElementById('fecha').innerHTML = dia + '/' + mes + '/' + year;
            document.getElementById('hora').innerHTML = horas + ':' + minutos + ':' + segundos;
            var t = setTimeout(function() {
                getHora()
            }, 1000)
        }

        function ajustar(h) {
            if (h < 10) {
                h = '0' + h;
            }
            return h;
        }
   