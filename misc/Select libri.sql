Select l.idLibro, l.titolo, g.genere, l.costo, l.giacenza, a.nome, a.cognome , e.nome as casaed
from Libro as l, Autore as a, CasaEditrice as e , Genere as g
where l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd and l.idGenere =g.idGenere
ORDER BY l.titolo