import { useEffect, useState } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Button } from "primereact/button";

import { API_URL } from "../api/api";
import { Bus } from "../interfaces/Bus";

export default function Table() {
  const [buses, setBuses] = useState<Bus[]>([]);

  // const [filters, setFilters] = useState({
  //   global: { value: null, matchNode: FilterMatchMode.CONTAINS },
  //   busesid: { value: null, matchNode: FilterMatchMode.CONTAINS },
  //   busesnumero: { value: null, matchNode: FilterMatchMode.CONTAINS },
  //   busesplaca: { value: null, matchNode: FilterMatchMode.CONTAINS },
  //   busesfecha: { value: null, matchNode: FilterMatchMode.CONTAINS },
  //   busescaracteristicas: { value: null, matchNode: FilterMatchMode.CONTAINS },
  //   busesmarcanombre: { value: null, matchNode: FilterMatchMode.CONTAINS },
  //   busesestado: { value: null, matchNode: FilterMatchMode.CONTAINS },
  // });

  const formatDate = (date: Date) => {
    const day = date.getDate().toString().padStart(2, "0");
    const month = (date.getMonth() + 1).toString().padStart(2, "0");
    const year = date.getFullYear();

    return `${day}-${month}-${year}`;
  };

  const fetchBuses = async () => {
    try {
      const response = await fetch(`${API_URL}/getAllBuses`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!response.ok) {
        throw new Error("Error al obtener los buses");
      }

      const data = await response.json();

      console.log("LISTA DE BUSES ANTES: ", data);

      const formattedBus = data.map((bus: Bus) => ({
        ...bus,
        busesfecha: formatDate(new Date(bus.busesfecha)),
      }));

      console.log("LISTA DE BUSES FORMATEADA: ", formattedBus);

      setBuses(formattedBus);
    } catch (error) {
      console.error("Error al obtener los buses", error);
      throw error; // Lanza el error para que pueda ser manejado por el componente
    }
  };

  // Función para obtener un bus por su ID
  const fetchBusById = async (id: number) => {
    try {
      const response = await fetch(`${API_URL}/getBusById/${id}`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!response.ok) {
        throw new Error(`Error al obtener el bus con ID ${id}`);
      }

      const bus = await response.json();

      const busDetalle = `
        Numero de Bus: ${bus.busesid}
        Placa: ${bus.busesplaca}
        Fecha de Creación: ${formatDate(new Date(bus.busesfecha))}
        Características: ${bus.busescaracteristicas}
        Marca: ${bus.busesmarcanombre}
        Estado: ${bus.busesestado}
      `;

      alert(busDetalle);
    } catch (error) {
      console.error(`Error al obtener el bus con ID ${id}`, error);
      throw error;
    }
  };

  useEffect(() => {
    fetchBuses();
  }, []);

  return (
    <div className="card">
      <DataTable
        value={buses}
        paginator
        rows={5}
        rowsPerPageOptions={[5, 10, 25, 50]}
        removableSort
      >
        <Column field="busesid" header="Id" filter sortable></Column>
        <Column
          field="busesnumero"
          header="Número de Bus"
          filter
          sortable
        ></Column>
        <Column field="busesplaca" header="Placa" filter></Column>
        <Column
          field="busesfecha"
          header="Fecha de Creación"
          filter
          sortable
        ></Column>
        <Column field="busescaracteristicas" header="Características"></Column>
        <Column field="busesmarcanombre" header="Marca de Bus" filter></Column>
        <Column field="busesestado" header="Estado" sortable filter></Column>
        <Column
          header="Acciones"
          body={(rowData: Bus) => (
            <Button
              label="Detalle"
              icon="pi pi-info-circle"
              onClick={() => fetchBusById(rowData.busesid)}
            />
          )}
        ></Column>
      </DataTable>
    </div>
  );
}

// • Id (autogenerado)
// • Número de bus
// • Placa
// • Fecha de Creación (autogenerada)
// • Características
// • Marca de bus (Volvo, Scania, Fiat, etc)
// • Activo o Inactivo
