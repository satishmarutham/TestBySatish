package com.centris.campus.util;

public class TransportUtilConstants {

	public static final String GET_ALL_VEHICLE_DETAILS = "select VehicleCode,VehicleName,Vehicle_Reg_No,VehicleType,Type_Of_Body,Makers_name,Manifacture_Date,Chassis_No,Seating_Capacity,Fuel_Type,Body_Color from transport_vehicle order by VehicleType";
	public static final String SAVE_VEHICLE_DETAILS = "insert into transport_vehicle(VehicleCode,Vehicle_Reg_No,VehicleName,VehicleType,Type_Of_Body,Makers_name,Manifacture_Date,Chassis_No,Seating_Capacity,Fuel_Type,Body_Color,CreateDate,CreateUser) values(?,?,?,?,?,?,?,?,?,?,?,now(),?)";
	public static final String CHECKING_VEHICLE_INSURANCE_DATE = "select count(*) from transport_vehicle_insurancedetails where VehicleCode= ? and (? between IssuedDate and ExpiryDate or ? between IssuedDate and ExpiryDate)";
	public static final String SAVE_VEHICLE_INSURANCE_DETAILS = "insert into transport_vehicle_insurancedetails(VehicleCode,CompanyName,IssuedDate,ExpiryDate,doneby,updatedBy,updatedTime) values(?,?,?,?,?,?,now())";
	public static final String GET_VEHCILE_INSURANCE_DETAILS = "select veh.VehicleCode,veh.Vehicle_Reg_No,veh.VehicleName,veh.VehicleType,veh.Type_Of_Body,veh.Makers_name,veh.Manifacture_Date,veh.Chassis_No,veh.Seating_Capacity,veh.Fuel_Type,veh.Body_Color,ins.CompanyName,ins.IssuedDate,ins.ExpiryDate,ins.doneby from transport_vehicle veh,transport_vehicle_insurancedetails ins where ins.VehicleCode=veh.VehicleCode and veh.VehicleCode=?";
	public static final String UPDATE_VEHICLE_DETAILS = "update transport_vehicle set Vehicle_Reg_No=?,VehicleName=?,VehicleType=?,Type_Of_Body=?,Makers_name=?,Manifacture_Date=?,Chassis_No=?,Seating_Capacity=?,Fuel_Type=?,Body_Color=?,UpdateDate=?,UpdateUser=? where VehicleCode=?";
	public static final String UPDATE_VEHICLE_INSURANCE_DETAILS = "update transport_vehicle_insurancedetails set CompanyName=?,IssuedDate=?,ExpiryDate=?,doneby=?,updatedBy=?,updatedTime=? where VehicleCode=?";
	public static final String DELETE_VEHICLE_DETAILS = "delete from transport_vehicle where VehicleCode=?";
	public static final String VALIDATE_VEHICLE_REG_NO = "select count(*) from transport_vehicle where Vehicle_Reg_No= ?";
	public static final String VALIDATE_UPDATE_VEHICLE_REG_NO = "select count(*) from transport_vehicle where Vehicle_Reg_No = ? and VehicleCode !=?";
	public static final String VALIDATE_VEHICLE_CHASSIS_NO = "select count(*) from transport_vehicle where Chassis_No= ?";
	public static final String VALIDATE_UPDATE_VEHICLE_CHASSIS_NO = "select count(*) from transport_vehicle where Chassis_No = ? and VehicleCode !=?";
	public static final String DELETE_INSURANCE_DETAILS = "delete from transport_vehicle_insurancedetails where VehicleCode=?";
	public static final String SEARCH_VEHICLE_DETAILS = "select * from transport_vehicle where Vehicle_Reg_No like ? or VehicleName like ? or VehicleType like ? or Type_Of_Body like ? or Makers_name like ? or Manifacture_Date like ? or Chassis_No like ? or Fuel_Type like ?";
	public static final String CHECK_FOR_DUPLICATE_ADD_TIME = "select count(*) from transport_vehicle where Vehicle_Reg_No=? and VehicleName=? and VehicleType=? and Type_Of_Body=? and Makers_name=? and Manifacture_Date=? and Chassis_No=? and Fuel_Type=?";
	public static final String CHECK_FOR_DUPLICATE_UPDATE_TIME = "select count(*) from transport_vehicle where Vehicle_Reg_No=? and VehicleName=? and VehicleType=? and Type_Of_Body=? and Makers_name=? and Manifacture_Date=? and Chassis_No=? and Fuel_Type=? and VehicleCode!=?";

	// route master start
	public static final String ROUTE_ALLLISTDATAS = "select RouteName,RouteCode,Route_No,Start_Time,End_Time,Total_Stops,TotalDistance,HaltTime,Destination from transport_route";
	public static final String ROUTE_INSERT = "insert into transport_route(RouteCode,RouteName,Route_No,Route_logical_name,Destination,HaltTime,Start_Time,End_Time,Total_Stops,TotalDistance,CreateDate,CreateUser) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String TRANSPORT_ROUTECHECK = "SELECT distinct(count(*)) FROM transport_route where Route_No=?";
	public static final String TRANSPORT_ROUTECHECK_WHILE_UPDATING = "SELECT distinct(count(*)) FROM transport_route where Route_No=? and RouteCode != ?";
	public static final String ROUTE_CREATEDTIME = "select CreateDate  from transport_route where RouteCode  =?";
	public static final String ROUTE_UPDATEROUTEMASTER = "update transport_route set RouteName=?,Route_No=?,Route_logical_name=?,Destination=?,HaltTime=?,Start_Time=?,End_Time=?,Total_Stops=?,TotalDistance=?,UpdateDate=?,UpdateUser=? where RouteCode=?";
	public static final String ROUTE_REMOVEFEE = "delete from transport_route where RouteCode=?";
	public static final String ADD_ROUTE_STOPDETAILS = "insert into transport_stopsdetails(StopCode,RouteCode,Stop_Name,ArrivalTime,HaltTime,DepTime,Distance) values(?,?,?,?,?,?,?)";
	public static final String ETID_ROUTE_ALLLISTDATAS = "select RouteName,RouteCode,Route_No,Route_logical_name,Destination,HaltTime,Start_Time,End_Time,Total_Stops,TotalDistance from transport_route where RouteCode =?";
	public static final String ROUTE_SEARCHLISTDATAS = "select RouteName,RouteCode,Route_No,Route_logical_name,RouteType,Cost_per_person,Start_Time,End_Time,Total_Stops,TotalDistance from transport_route where RouteName like ? or Route_logical_name like ? or RouteType like ?";

	public static final String GET_STOP_NAMES = "select stage_id,stage_name from campus_fee_stage";

	// route master end

	// fuel maintenance

	public static final String GET_FUEL_DETAILS = "select f.VehicleCode,f.DriverCode,f.FuelCode,f.fueldate,v.VehicleType,v.Vehicle_Reg_No,d.Name,f.FuelType,f.Quantity,f.FuelCost,f.MeterReading,f.Location from transport_vehicle v,transport_fuel_maintainence f,transport_driver d where f.DriverCode=d.DriverCode and f.VehicleCode=v.VehicleCode";
	public static final String ADD_FUEL_DETAILS = "insert into transport_fuel_maintainence(FuelCode,VehicleCode,fueldate,FuelType,DriverCode,Quantity,FuelCost,MeterReading,Location,CreateDate,CreateUser) values(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SEARCH_VEHICLE = "select VehicleCode,Vehicle_Reg_No,VehicleType from transport_vehicle where VehicleType like ?";
	public static final String GET_VEHICLE_NO = "select VehicleCode,Vehicle_Reg_No,VehicleType from transport_vehicle where VehicleCode=?";
	public static final String DELETE_FUEL_DETAILS = "Delete from transport_fuel_maintainence where FuelCode=?";
	public static final String EDIT_FUEL_DETAILS = "select ve.VehicleCode,dr.DriverCode,fu.FuelCode,ve.VehicleType,fu.fueldate,ve.Vehicle_Reg_No,dr.Name,fu.FuelType,fu.Quantity,fu.FuelCost,fu.MeterReading,fu.Location from transport_fuel_maintainence fu join transport_driver dr on dr.DriverCode=fu.DriverCode join transport_vehicle ve on ve.VehicleCode=fu.VehicleCode where fu.FuelCode= ?";
	public static final String UPDATE_FUEL_DETAILS = "update transport_fuel_maintainence set VehicleCode=?,fueldate=?,FuelType=?,DriverCode=?,Quantity=?,FuelCost=?,MeterReading=?,Location=?,UpdateDate=?,UpdateUser=? where FuelCode=?";
	public static final String SEARCH_FUEL_DETAILS = "select fu.fueldate,fu.Location,fu.FuelType,ve.VehicleType,ve.Vehicle_Reg_No,dr.Name,fu.Quantity,fu.FuelCost,fu.MeterReading from transport_fuel_maintainence fu join transport_vehicle ve on ve.VehicleCode=fu.VehicleCode join transport_driver dr on dr.DriverCode=fu.DriverCode where (fu.fueldate like ? or fu.Location like ? or fu.FuelType like ? or ve.VehicleType like ? or ve.Vehicle_Reg_No like ? or dr.Name LIKE ? )";
	public static final String SEARCH_DRIVER = "select DriverCode,Name from transport_driver where Name like ?";

	// Driver master

	public static final String GET_DRIVER_LIST = "select * from transport_driver";
	public static final String ADD_DRIVER = "insert into transport_driver (DriverCode,type,Name,FatherName,DOB,MobileNo,EmergencyContactNo,Address,DOJ,Age,Gender,DLNo,DLIssuedDate,DLExpirayDate,LicencetoDrive,CreateDate,CreateUser,Experience) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_DRIVER_DETAILS = "select DriverCode,Name,FatherName,DOB,MobileNo,EmergencyContactNo,Experience,Address,DOJ,Age,Gender,DLNo,DLIssuedDate,DLExpirayDate,LicencetoDrive from transport_driver where DriverCode=?";
	public static final String DELETE_DRIVER = "delete from transport_driver where DriverCode=?";
	public static final String SEARCH_DRIVER_DETAILS = "select * from transport_driver where  Name like ? or DOJ like ? or MobileNo like ? or DLNo like ? or DLIssuedDate like ? or DLExpirayDate like ?";
	public static final String UPDATE_DRIVER = "update transport_driver set Name=?,FatherName=?,DOB=?,MobileNo=?,EmergencyContactNo=?,Address=?,DOJ=?,Age=?,Gender=?,DLNo=?,DLIssuedDate=?,DLExpirayDate=?,LicencetoDrive=? ,UpdateDate=? ,UpdateUser=?,Experience=? where DriverCode=?";
	public static final String VALIDATE_DRIVER = "select count(*) driverCount from transport_driver where  Name=? and DOB=? and MobileNo=? and Address=? and DOJ=?";

	// driver mapping
	public static final String GET_UNMAPPED_DRIVER_DETAILS = "select distinct td.DriverCode,td.Name from transport_driver td,transport_driver_vehicle_mapping tdm where td.DriverCode not in (select DriverCode from transport_driver_vehicle_mapping)";
	public static final String GET_DRIVER_DETAILS_BY_ID = "select DriverCode,Name,MobileNo,Experience,DOJ,DLNo,DLIssuedDate,DLExpirayDate,LicencetoDrive from transport_driver where DriverCode=?";
	public static final String GET_UNMAPPED_DRIVER_DETAILS_WHILE_UPDATE = "select distinct td.DriverCode,td.Name from transport_driver td,transport_driver_vehicle_mapping tdm where td.DriverCode not in (select DriverCode from transport_driver_vehicle_mapping where VehicleCode != ?)";
	public static final String GET_SINGLE_DRIVER_DETAILS = "select distinct dr.DriverCode,dr.Name,dr.MobileNo,dr.Experience,dr.DOJ,dr.DLNo,dr.DLIssuedDate,dr.DLExpirayDate,dr.LicencetoDrive from transport_vehicle veh,transport_vehicle_insurancedetails ins,transport_driver dr,transport_driver_vehicle_mapping drm where ins.VehicleCode=veh.VehicleCode and dr.DriverCode in(select DriverCode from transport_driver_vehicle_mapping where VehicleCode =?) and veh.VehicleCode=?";
	public static final String MAP_DRIVER_VEHICLE_INSERTING = "insert into transport_driver_vehicle_mapping(DriverCode,VehicleCode,Createdby,Createtime)value(?,?,?,now())";
	public static final String MAP_DRIVER_VEHICLE_WHILE_UPDATE = "update transport_driver_vehicle_mapping set DriverCode=?,VehicleCode=?,Modifiedby=?,ModifiedDate=now() where VehicleCode=?";
	public static final String CHECKING_DRIVER = "select count(*) from transport_driver_vehicle_mapping where DriverCode=?";

	// route
	public static final String GET_ROUTE_NAMES = "select RouteCode,RouteName from transport_route";
	public static final String GET_ROUTE_DETAILS = "select RouteCode,RouteName,TotalDistance,Route_No,Total_Stops,Destination,HaltTime from transport_route where RouteCode = ?";
	public static final String MAP_DRIVER_VEHICLE_ROUTE_MAPPING = "insert into transport_vehicle_route_mapping(RouteCode,VehicleCode,CreateUser,CreateDate)value(?,?,?,now())";
	public static final String MAP_DRIVER_VEHICLE_ROUTE_MAPPING_UPDATING = "update transport_vehicle_route_mapping set RouteCode=?,VehicleCode=?,CreateUser=?,CreateDate=now() where  VehicleCode =?";
	public static final String CHECK_VEHICLE_MAPPING = "select count(*) from transport_vehicle_route_mapping where VehicleCode = ?";
	public static final String GET_ROUTE_DETAILS_EDIT = "select rt.RouteCode,rt.RouteName,rt.TotalDistance,rt.Route_No,rt.Total_Stops,rt.Destination,rt.HaltTime from transport_route rt,transport_vehicle_route_mapping tmv where rt.RouteCode = tmv.RouteCode and tmv.VehicleCode in(select VehicleCode from transport_vehicle where VehicleCode = ?)";

	public static final String ROUTE_ALLLISTDATASTOP = "select tr.RouteName,tr.RouteCode,tr.Route_No,tr.Start_Time,tr.End_Time,tr.Total_Stops,tr.TotalDistance,tr.HaltTime,tr.Destination,sto.Stop_Name,sto.ArrivalTime,sto.DepTime,sto.Distance from transport_route tr join transport_stopsdetails sto on sto.RouteCode=tr.RouteCode";

	
}
