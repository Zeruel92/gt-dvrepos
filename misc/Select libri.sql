Select l.idLibro, l.titolo, l.genere, l.costo, l.giacenza, a.nome, a.cognome , e.nome as casaed
from Libro as l, Autore as a, CasaEditrice as e
where l.idAutore=a.idAutore and l.idCasaEd=e.idCasaEd 
ORDER BY l.titolo desc